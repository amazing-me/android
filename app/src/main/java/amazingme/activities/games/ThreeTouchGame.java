package amazingme.activities.games;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amazingme.activities.R;

import java.util.Timer;
import java.util.TimerTask;

import amazingme.activities.util.GameTitle;
import amazingme.activities.util.Icon;
import amazingme.app.EnumeratedActivity;
import amazingme.model.AmazingMeGame;
import amazingme.model.GameResult;
import amazingme.model.Milestone;
import amazingme.model.Problem;

//touch the screen three times within a minute to complete this.
@Icon(R.drawable.amazingbackground)
@GameTitle("Three Touch Game")
public class ThreeTouchGame extends AmazingMeGame {

    private static final int TIME_SECS = 60;

    private int seconds = TIME_SECS;

    private Timer timer;
    private TimerTask gameTask;

    private int redCount;
    private int blueCount ;

    public ThreeTouchGame() {
        super(R.layout.activity_game_three_touch);
        this.relatedMilestones = new Milestone[] {Milestone.UNDERSTANDS_WORDS_LIKE_IN_ON_OR_UNDER};
    }

    @Override
    public GameResult gameResults() {
        GameResult result = new GameResult();

        if(redCount < 3 || blueCount > 0) {
            result.addProblem(Problem.DID_NOT_FOLLOW_DIRECTIONS);
        }
        if(seconds == 0) {
            result.addProblem(Problem.TIME_TOO_LONG);
        }


        int score = (redCount == 3 && blueCount == 0) ? 50 : 0;
        score += Math.max((60 - seconds), 50);
        result.setScore(score);

        return result;
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.THREE_TOUCH_GAME;
    }

    @Override
    public void bindToUserInterface() {
        final TextView timeText = (TextView)findViewById(R.id.game_three_touch_time_text);
        final TextView secondsText = (TextView)findViewById(R.id.game_three_touch_seconds_text);

        timer = new Timer();
        gameTask = new TimerTask() {
            @Override
            public void run() {
                seconds--;
                if(seconds == 0) {
                    timer.cancel();
                    resign(true);
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        secondsText.setText(String.format("%d second%s", seconds, seconds == 1 ? "" : "s"));
                    }
                });
            }
        };

        final Button redButton = (Button)findViewById(R.id.game_three_touch_red_button);
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(++redCount == 3) {
                    timer.cancel();
                    resign(true);
                }
            }
        });

        final Button blueButton = (Button)findViewById(R.id.game_three_touch_blue_button);
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(++blueCount == 3) {
                    timer.cancel();
                    resign(true);
                }
            }
        });

        final Button startButton = (Button)findViewById(R.id.game_three_touch_start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        redButton.setVisibility(View.VISIBLE);
                        blueButton.setVisibility(View.VISIBLE);
                        timeText.setVisibility(View.VISIBLE);
                        secondsText.setVisibility(View.VISIBLE);

                        startButton.setVisibility(View.INVISIBLE);
                    }
                });

                timer.scheduleAtFixedRate(gameTask, 1000, 1000);
            }
        });

    }

}
