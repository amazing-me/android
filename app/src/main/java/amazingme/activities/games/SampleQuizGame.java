package amazingme.activities.games;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.amazingme.activities.R;

import java.util.Timer;
import java.util.TimerTask;

import amazingme.activities.util.GameInfo;
import amazingme.activities.util.Icon;
import amazingme.app.EnumeratedActivity;
import amazingme.app.AmazingMeGame;
import amazingme.app.GameLoopService;
import amazingme.app.GameTimerService;
import amazingme.model.GameResult;
import amazingme.model.Milestone;
import amazingme.model.Problem;

@GameInfo(
        value = "Sample Quiz Game",
        instruction = "Answer the questions",
        milestones = {Milestone.CAN_NAME_MOST_FAMILIAR_THINGS}
)

public class SampleQuizGame extends AmazingMeGame {

    private String shapes_questions[] = {
            "Which shape has four sides?",
    };

    private String shapes_answers[][] = {
            {"circle","square","triangle","star"},
    };

    private String shapes_answers_correct[] = {
            "circle", "square"
    };
    private int score;

    public SampleQuizGame(){
        super(R.layout.activity_game_sample_quiz);
    }
    private int currQuestion = 0;
    @Override
    public void updateGameResults() {
        GameResult canNameMostFamiliarThings = new GameResult();

        canNameMostFamiliarThings.setRelatedMilestone(Milestone.CAN_NAME_MOST_FAMILIAR_THINGS);

        canNameMostFamiliarThings.setScore(score);

        gameResults.add(canNameMostFamiliarThings);
    }

    @Override
    public void initGame() {
        TextView questionText = (TextView)findViewById(R.id.question);
        TextView scoreText = (TextView)findViewById(R.id.score);

        Button answer1 = (Button)findViewById(R.id.answer1);
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shapes_answers[currQuestion][0].equals(shapes_answers_correct[currQuestion])) {
                    score++;
                    resignGame(true);
                } else {
                    resignGame(false);
                }
            }
        });
        Button answer2 = (Button) findViewById(R.id.answer2);
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shapes_answers[currQuestion][1].equals(shapes_answers_correct[currQuestion])) {
                    score++;
                    resignGame(true);
                } else {
                    resignGame(false);
                }
            }
        });
        Button answer3 = (Button) findViewById(R.id.answer3);
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shapes_answers[currQuestion][2].equals(shapes_answers_correct[currQuestion])) {
                    score++;
                    resignGame(true);
                } else {
                    resignGame(false);
                }
            }
        });
        Button answer4 = (Button) findViewById(R.id.answer4);
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(shapes_answers[currQuestion][3].equals(shapes_answers_correct[currQuestion])) {
                    score++;
                    resignGame(true);
                } else {
                    resignGame(false);
                }
            }
        });
        questionText.setText(shapes_questions[currQuestion]);
        scoreText.setText(score);
        answer1.setText(shapes_answers[currQuestion][0]);
        answer2.setText(shapes_answers[currQuestion][1]);
        answer3.setText(shapes_answers[currQuestion][2]);
        answer4.setText(shapes_answers[currQuestion][3]);

    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.SAMPLE_QUIZ_GAME;
    }

    @Override
    public void bindToUserInterface() {

    }
}
