package amazingme.activities.games;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amazingme.activities.R;

import java.util.Random;

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

    public String mQuestions[] = {
            "The koala on the above picture is ...",
            "The koala on the above picture is ...",
            "The koala on the above picture is ...",
            "The koala on the above picture is ..."
    };

    private String mChoices[][] = {
            {"sitting on the floor", "sitting on the table", "playing with the duck", "playing with the penguin"},
            {"playing with the duck", "sitting on the table", "playing with the penguin", "sitting on the floor"},
            {"playing with the penguin", "sitting on the table", "sitting on the floor", "playing with the duck"},
            {"sitting on the table", "sitting on the floor", "playing with the duck", "playing with the penguin"}
    };

    public int mImages[] = {
            R.drawable.sample_game_image1,
            R.drawable.sample_game_image2,
            R.drawable.sample_game_image3,
            R.drawable.sample_game_image4
    };

    private String mCorrectAnswers[] = {
            "sitting on the floor", "sitting on the table", "playing with the duck", "playing with the penguin"
    };

    Button answer1, answer2, answer3, answer4;
    TextView score, question, title;
    ImageView image;

    private String mAnswer;
    private int mScore = 0;
    private int mQuestionsLength = mQuestions.length;

    Random r;

    int currRand = 0;
    int prevRand = 0;
    int questionNum = 1;
    int earnedScore;

    public SampleQuizGame(){
        super(R.layout.activity_game_sample_quiz);
    }

    @Override
    public void initGame() {

        r = new Random();

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);

        score = (TextView) findViewById(R.id.score);
        title = (TextView) findViewById(R.id.title);
        question = (TextView) findViewById(R.id.question);

        image = (ImageView) findViewById(R.id.image);

        currRand = r.nextInt(mQuestionsLength);
        while (prevRand == currRand) {
            currRand = r.nextInt(mQuestionsLength);
        }
        updateQuestion(currRand);
        prevRand = currRand;


        score.setText("Score: " + mScore);
        title.setText("Question # : " + questionNum);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer1.getText() == mAnswer) {
                    nextQuestion();
                    mScore++;
                    questionNum++;
                    score.setText("Score: " + mScore);
                    title.setText("Question # : " + questionNum);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameOver();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer2.getText() == mAnswer) {
                    nextQuestion();
                    mScore++;
                    questionNum++;
                    score.setText("Score: " + mScore);
                    title.setText("Question # : " + questionNum);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameOver();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer3.getText() == mAnswer) {
                    nextQuestion();
                    mScore++;
                    questionNum++;
                    score.setText("Score: " + mScore);
                    title.setText("Question # : " + questionNum);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameOver();
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer4.getText() == mAnswer) {
                    nextQuestion();
                    mScore++;
                    questionNum++;
                    score.setText("Score: " + mScore);
                    title.setText("Question # : " + questionNum);
                    updateQuestion(r.nextInt(mQuestionsLength));
                } else {
                    gameOver();
                }
            }
        });
    }

    @Override
    public void updateGameResults() {
        GameResult canNameMostFamiliarThings = new GameResult();

        canNameMostFamiliarThings.setRelatedMilestone(Milestone.CAN_NAME_MOST_FAMILIAR_THINGS);

        canNameMostFamiliarThings.setScore(earnedScore);

        gameResults.add(canNameMostFamiliarThings);
    }

    private void updateQuestion(int num) {
        question.setText(getQuestion(num));

        answer1.setText(getChoice1(num));
        answer2.setText(getChoice2(num));
        answer3.setText(getChoice3(num));
        answer4.setText(getChoice4(num));

        image.setImageResource(getImage(num));
        mAnswer = getCorrectAnswer(num);
    }

    private void gameOver() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SampleQuizGame.this);
        alertDialogBuilder
                .setMessage("Game Over! Your score is " + mScore + " points.")
                .setCancelable(false)
                .setPositiveButton("NEW GAME", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(new Intent(getApplicationContext(), SampleQuizGame.class));
                        finish();
                    }
                })
                .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void nextQuestion() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(SampleQuizGame.this);
        alertDialogBuilder
                .setMessage("Great! Let's go for the next question!.");
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.SAMPLE_QUIZ_GAME;
    }

    public int getImage(int a) {
        int image = mImages[a];
        return image;
    }

    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a) {
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a) {
        String choice = mChoices[a][2];
        return choice;
    }

    public String getChoice4(int a) {
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
