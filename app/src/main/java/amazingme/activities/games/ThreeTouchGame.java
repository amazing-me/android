package amazingme.activities.games;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amazingme.activities.R;

import amazingme.activities.util.GameInfo;
import amazingme.activities.util.Icon;
import amazingme.app.EnumeratedActivity;
import amazingme.app.AmazingMeGame;
import amazingme.app.GameLoopService;
import amazingme.app.GameTimerService;
import amazingme.model.GameResult;
import amazingme.model.Milestone;
import amazingme.model.Problem;

//touch the screen three times within a minute to complete this.
@Icon(R.drawable.amazingbackground)
@GameInfo(
        value = "Three Touch Game",
        instruction = "Touch the red button 3 times within one minute",
        milestones = {Milestone.UNDERSTANDS_WORDS_LIKE_IN_ON_AND_UNDER}
)
public class ThreeTouchGame extends AmazingMeGame {

    private static final int TIME_SECS = 60;

    private int seconds = TIME_SECS;
    private int redCount;
    private int blueCount ;

    private TextView secondsText;
    private GameTimerService timer;

    public ThreeTouchGame() {
        super(R.layout.activity_game_three_touch);
    }

    public void initGame() {
        secondsText = (TextView)findViewById(R.id.game_three_touch_seconds_text);

        getService(GameLoopService.class, new GameLoopService.Config(60,
            new Runnable() {
                @Override
                public void run() {

                }
            },
            new Runnable() {
                @Override
                public void run() {

                }
            }
        ));
        timer = getService(GameTimerService.class, new GameTimerService.Config(60, R.id.game_three_touch_seconds_text,
            new Runnable() {
                @Override
                public void run() {
                    resignGame(true);
                }
            }
        ));

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

                startGame();
            }
        });
    }

    @Override
    public void updateGameResults() {
        GameResult understandsWordsLikeInOnAndUnder = new GameResult();

        understandsWordsLikeInOnAndUnder.setRelatedMilestone(Milestone.UNDERSTANDS_WORDS_LIKE_IN_ON_AND_UNDER);

        if(redCount < 3 || blueCount > 0) {
            understandsWordsLikeInOnAndUnder.addProblem(Problem.DID_NOT_FOLLOW_DIRECTIONS);
        }
        if(timer.getSeconds() == 0) {
            understandsWordsLikeInOnAndUnder.addProblem(Problem.TIME_TOO_LONG);
        }

        int score = ((redCount == 3 && blueCount == 0) ? 40 : 0) + timer.getSeconds();
        understandsWordsLikeInOnAndUnder.setScore(score);

        gameResults.add(understandsWordsLikeInOnAndUnder);
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.THREE_TOUCH_GAME;
    }

}
