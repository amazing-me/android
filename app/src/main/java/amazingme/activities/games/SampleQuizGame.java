package amazingme.activities.games;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.amazingme.activities.R;

import amazingme.activities.util.GameInfo;
import amazingme.app.AmazingMeGame;
import amazingme.app.EnumeratedActivity;
import amazingme.model.GameResult;
import amazingme.model.Milestone;

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

        ImageButton answer1 = (ImageButton)findViewById(R.id.answer1);
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
        ImageButton answer2 = (ImageButton) findViewById(R.id.answer2);
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
        ImageButton answer3 = (ImageButton) findViewById(R.id.answer3);
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
        ImageButton answer4 = (ImageButton) findViewById(R.id.answer4);
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

        Button submitBtn = (Button)findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert(v);
            }
        });


//        answer1.setText(shapes_answers[currQuestion][0]);
//        answer2.setText(shapes_answers[currQuestion][1]);
//        answer3.setText(shapes_answers[currQuestion][2]);
//        answer4.setText(shapes_answers[currQuestion][3]);

    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.SAMPLE_QUIZ_GAME;
    }

    @Override
    public void bindToUserInterface() {

    }

    // This is just temporary for testing
    // When you click images, this makes message to show up
    public void showAlert(View v) {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage("You chose " + v.getResources().getResourceEntryName(v.getId()) + ".").create();
        myAlert.show();
    }

    public void showAlert2(View v) {
        AlertDialog.Builder myAlert = new AlertDialog.Builder(this);
        myAlert.setMessage("You submitted !").create();
        myAlert.show();
    }
}
