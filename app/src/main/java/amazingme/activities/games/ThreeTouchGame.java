package amazingme.activities.games;


import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amazingme.activities.R;

import java.util.LinkedList;
import java.util.List;
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
    private int redCount;
    private int blueCount ;

    private TextView secondsText;

    public ThreeTouchGame() {
        super(R.layout.activity_game_three_touch);
        this.relatedMilestones = new Milestone[] {Milestone.UNDERSTANDS_WORDS_LIKE_IN_ON_AND_UNDER};
    }

    @Override
    public void bindToUserInterface() {
        secondsText = (TextView)findViewById(R.id.game_three_touch_seconds_text);

        final TextView timeText = (TextView)findViewById(R.id.game_three_touch_time_text);
        final Button redButton = (Button)findViewById(R.id.game_three_touch_red_button);
        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPaused() && ++redCount == 3) {
                    resignGame(true);
                }
            }
        });

        final Button blueButton = (Button)findViewById(R.id.game_three_touch_blue_button);
        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPaused() && ++blueCount == 3) {
                    resignGame(true);
                }
            }
        });

        final Button pauseButton = (Button)findViewById(R.id.game_three_touch_pause_button);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPaused()) {
                    unpauseGame();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            pauseButton.setText("Pause");
                        }
                    });
                } else {
                    pauseGame();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            pauseButton.setText("Unpause");
                        }
                    });
                }
            }
        });

        final Button stopButton = (Button)findViewById(R.id.game_three_touch_stop_button);
        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resignGame(false);
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
                        pauseButton.setVisibility(View.VISIBLE);
                        stopButton.setVisibility(View.VISIBLE);

                        startButton.setVisibility(View.INVISIBLE);
                    }
                });

                startGame(1000);
            }
        });
    }

    @Override
    public void gameLogicUpdate() {
        seconds--;
        if(seconds == 0) {
            resignGame(true);
        }
    }

    @Override
    public void gameUIUpdate() {
        secondsText.setText(String.format("%d second%s", seconds, seconds == 1 ? "" : "s"));
    }

    @Override
    public void updateGameResults() {
        GameResult understandsWordsLikeInOnAndUnder = new GameResult();

        understandsWordsLikeInOnAndUnder.setRelatedMilestone(Milestone.UNDERSTANDS_WORDS_LIKE_IN_ON_AND_UNDER);

        if(redCount < 3 || blueCount > 0) {
            understandsWordsLikeInOnAndUnder.addProblem(Problem.DID_NOT_FOLLOW_DIRECTIONS);
        }
        if(seconds == 0) {
            understandsWordsLikeInOnAndUnder.addProblem(Problem.TIME_TOO_LONG);
        }

        int score = ((redCount == 3 && blueCount == 0) ? 40 : 0) + seconds;
        understandsWordsLikeInOnAndUnder.setScore(score);

        gameResults.add(understandsWordsLikeInOnAndUnder);
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.THREE_TOUCH_GAME;
    }

}
