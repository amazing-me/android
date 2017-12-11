package amazingme.activities.games;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.amazingme.activities.R;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import amazingme.activities.util.GameInfo;
import amazingme.app.AmazingMeGame;
import amazingme.app.EnumeratedActivity;
import amazingme.app.GameLoopService;
import amazingme.app.GameTimerService;
import amazingme.model.GameResult;
import amazingme.model.Milestone;
import amazingme.model.Problem;

@GameInfo(
        value = "Animal Picture Game",
        instruction = "Answer the questions based on the given picture",
        milestones = {Milestone.CAN_NAME_MOST_FAMILIAR_THINGS}
)

public class AnimalPictureGame extends AmazingMeGame {

    public String mQuestions[] = {
            // 1
            "How many is the number of pieces around the koala?",
            "How many is the number of ORANGE pieces around the koala?",

            // 2
            "Where is the koala in the picture?",
            "What is the color of the table under the koala?",

            // 3
            "What is the alphabet written on the blue box at the back?",
            "Who is the turtle looking at?",

            // 4
            "Who is the penguin pushing down?",
            "What is the color of the ribbon on the penguin's head?",

            // 5
            "Where is the giraffe in the picture?",
            "What is the color of the glasses on the snake?",

            // 6
            "What is on the giraffe's left hand?",
            "How many brown spots on the giraffe's forehead?",

            // 7
            "Who is the tallest one in the picture?",
            "How many of them have blue eyes?",

            // 8
            "What is the color of the pillow?",
            "What is the koala doing with the pillow?",

            // 9
            "What is the koala leaning against?",
            "What color of the chair is the kangaroo jumping from?",

            // 10
            "Who is the shortest in the picture?",
            "Where is the snake from the koala?",

            // 11
            "Where is the giraffe based on the yellow box?",
            "What shape is drawn on the yellow box?",

            // 12
            "What is the elephant doing with the chair?",
            "What color of clothes is the elephant wearing under the white coat?",

            // 13
            "What shape is on the kangaroo's shirt?",
            "What is the kangaroo's doing with his hat?",

            // 14
            "Who is the one cutting the purple paper?",
            "What color is the paper that the pig is grabbing?",

            // 15
            "Which hand is the penguin grabbing the scissors with?",
            "Where is the pink ribbon based on the penguin?"
    };

    private String mChoices[][] = {
            // 1
            {"4", "8", "14", "10"},
            {"8", "4", "5", "3"},

            // 2
            {"Under the table", "On the table", "In front of the table", "Behind the table"},
            {"Pink", "Black", "Yellow", "Purple"},

            // 3
            {"A", "B", "C", "D"},
            {"Elephant", "Koala", "Duck", "Giraffe"},

            // 4
            {"Duck", "Pig", "Elephant", "Koala"},
            {"Black", "White", "Pink", "Green"},

            // 5
            {"Above the table", "Next to the table", "Behind the table", "Under the table"},
            {"Black", "Brown", "Orange", "Red"},

            // 6
            {"Chopsticks", "A pencil", "A cellphone", "Scissors"},
            {"5", "3", "4", "6"},

            // 7
            {"Elephant", "Giraffe", "Penguin", "Pig"},
            {"1", "2", "3", "4"},

            // 8
            {"Yellow", "Blue", "Green", "White"},
            {"Lying on it", "Sitting on it", "Leaning against it", "Carrying it"},

            // 9
            {"Computer", "Desk", "Trash Can", "Refrigerator"},
            {"Green", "White", "Pink", "Blue"},

            // 10
            {"Koala", "Snake", "Turtle", "Pig"},
            {"In front", "At the back", "Alongside", "Diagonally"},

            // 11
            {"On the box", "Under the box", "Next to the box", "Behind the box"},
            {"Triangle", "Rectangle", "Star", "Circle"},

            // 12
            {"Carrying it", "Pulling it", "Sitting on it", "Pushing it"},
            {"Brown", "Black", "Yellow", "Pink"},

            // 13
            {"Rectangle", "Star", "Circle", "Triangle"},
            {"Putting on", "Taking off", "Throwing", "Tearing off"},

            // 14
            {"Pig", "Duck", "Both of them", "No one"},
            {"Black", "Green", "Red", "Blue"},

            // 15
            {"Left", "Right", "Both of them", "No one"},
            {"Under the nose", "On the head", "On the left hand", "On the stomach"},
    };

    private String mCorrectAnswers[] = {
            // 1
            "14", "4",

            // 2
            "On the table", "Pink",

            // 3
            "B", "Duck",

            // 4
            "Koala", "Pink",

            // 5
            "Next to the table", "Black",

            // 6
            "Scissors", "6",

            // 7
            "Giraffe", "3",

            // 8
            "Green", "Leaning against it",

            // 9
            "Refrigerator", "Pink",

            // 10
            "Koala", "At the back",

            // 11
            "Behind the box", "Star",

            // 12
            "Sitting on it", "Pink",

            // 13
            "Star", "Putting on",

            // 14
            "Duck", "Blue",

            // 15
            "Right", "On the head"
    };

    public int mImages[] = {
            R.drawable.sample_game_image1,
            R.drawable.sample_game_image1,
            R.drawable.sample_game_image2,
            R.drawable.sample_game_image2,
            R.drawable.sample_game_image3,
            R.drawable.sample_game_image3,
            R.drawable.sample_game_image4,
            R.drawable.sample_game_image4,
            R.drawable.sample_game_image5,
            R.drawable.sample_game_image5,
            R.drawable.sample_game_image6,
            R.drawable.sample_game_image6,
            R.drawable.sample_game_image7,
            R.drawable.sample_game_image7,
            R.drawable.sample_game_image8,
            R.drawable.sample_game_image8,
            R.drawable.sample_game_image9,
            R.drawable.sample_game_image9,
            R.drawable.sample_game_image10,
            R.drawable.sample_game_image10,
            R.drawable.sample_game_image11,
            R.drawable.sample_game_image11,
            R.drawable.sample_game_image12,
            R.drawable.sample_game_image12,
            R.drawable.sample_game_image13,
            R.drawable.sample_game_image13,
            R.drawable.sample_game_image14,
            R.drawable.sample_game_image14,
            R.drawable.sample_game_image15,
            R.drawable.sample_game_image15
    };

    Button answer1, answer2, answer3, answer4;
    TextView score, question, title, secondsText, titleText, titleText1, titleText2, titleText3, timerText;
    ImageView image;

    private static final int TIME_SECS = 600;

    private int seconds = TIME_SECS;
    public Set<Integer> set;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionsLength = mQuestions.length;
    private boolean isGameComplete = false;

    Random r;

    int currRand = 0;
    int questionNum = 1;

    public AnimalPictureGame(){
        super(R.layout.activity_game_animal_picture);
    }

    @Override
    public void initGame() {

        r = new Random();
        set = new HashSet<>();

        final Button startButton = (Button)findViewById(R.id.startBtn);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        secondsText.setVisibility(View.VISIBLE);
                        answer1.setVisibility(View.VISIBLE);
                        answer2.setVisibility(View.VISIBLE);
                        answer3.setVisibility(View.VISIBLE);
                        answer4.setVisibility(View.VISIBLE);
                        score.setVisibility(View.VISIBLE);
                        title.setVisibility(View.VISIBLE);
                        question.setVisibility(View.VISIBLE);
                        image.setVisibility(View.VISIBLE);
                        timerText.setVisibility(View.VISIBLE);

                        titleText.setVisibility(View.INVISIBLE);
                        titleText1.setVisibility(View.INVISIBLE);
                        titleText2.setVisibility(View.INVISIBLE);
                        titleText3.setVisibility(View.INVISIBLE);
                        startButton.setVisibility(View.INVISIBLE);
                    }
                });

                startGame();
            }
        });

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);

        score = (TextView) findViewById(R.id.score);
        title = (TextView) findViewById(R.id.title);
        question = (TextView) findViewById(R.id.question);

        titleText = (TextView) findViewById(R.id.title_text);
        titleText1 = (TextView) findViewById(R.id.title_text1);
        titleText2 = (TextView) findViewById(R.id.title_text2);
        titleText3 = (TextView) findViewById(R.id.title_text3);
        timerText = (TextView) findViewById(R.id.timer_text);

        image = (ImageView) findViewById(R.id.image);

        avoidOverlapQuestion();

        score.setText("Score: " + mScore);
        title.setText("Question # : " + questionNum);

        secondsText = (TextView) findViewById(R.id.timer);

        getService(GameLoopService.class, new GameLoopService.Config(600,
                new Runnable() {
                    @Override
                    public void run() {
                        Log.d("", "test");
                    }
                },
                new Runnable() {
                    @Override
                    public void run() {

                    }
                }
        ));
        getService(GameTimerService.class, new GameTimerService.Config(600, R.id.timer,
                new Runnable() {
                    @Override
                    public void run() {
                        resignGame(true);
                    }
                }
        ));

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answer1.getText() == mAnswer) {
                    nextQuestion();
                    mScore++;
                    questionNum++;
                    score.setText("Score: " + mScore);
                    title.setText("Question # : " + questionNum);
                    avoidOverlapQuestion();
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
                    avoidOverlapQuestion();
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
                    avoidOverlapQuestion();
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
                    avoidOverlapQuestion();
                } else {
                    resignGame(true);
                    gameOver();
                }
            }
        });
    }

    @Override
    public void updateGameResults() {
        GameResult canNameMostFamiliarThings = new GameResult();

        canNameMostFamiliarThings.setRelatedMilestone(Milestone.CAN_NAME_MOST_FAMILIAR_THINGS);

        if(seconds == 0) {
            canNameMostFamiliarThings.addProblem(Problem.TIME_TOO_LONG);
        }

        int score = ((mScore * 2) + (seconds / 10));
        canNameMostFamiliarThings.setScore(score);

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
        String msg;
        if (isGameComplete) {
            msg = "Perfect! You finished all the questions! Your score is " + mScore + " points.";
        } else {
            msg = "Game Over! Your score is " + mScore + " points.";
        }
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(AnimalPictureGame.this);
        alertDialogBuilder
                .setMessage(msg)
                .setCancelable(false)
                .setPositiveButton("NEW GAME", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        resignGame(true);
                        startActivity(new Intent(getApplicationContext(), AnimalPictureGame.class));
                        finish();
                    }
                })
                .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        resignGame(true);
                        finish();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void nextQuestion() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(AnimalPictureGame.this);
        alertDialogBuilder
                .setMessage("Great! Let's go for the next question!.");
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.ANIMAL_PICTURE_GAME;
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

    // Avoid the same question to show up in a row
    public void avoidOverlapQuestion() {
        if (questionNum <= mQuestionsLength) {
            currRand = r.nextInt(mQuestionsLength);
            while (set.contains(currRand)) {
                currRand = r.nextInt(mQuestionsLength);
            }
            updateQuestion(currRand);
            set.add(currRand);
        } else {
            isGameComplete = true;
            gameOver();
        }
    }
}
