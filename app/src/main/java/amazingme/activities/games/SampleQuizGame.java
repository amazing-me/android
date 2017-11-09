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


/**
 * Created by caylavinzons on 11/9/17.
 */

public class SampleQuizGame extends AmazingMeGame {

    private String shapes_questions[] = {
            "Which shape has four sides?",
            "Which card shows a square?"
    };

    private String shapes_answers[][] = {
            {"circle","square","triangle","star"},
            {"circle", "square", "triangle", "star"}
    };

    private String shapes_answers_correct[] = {
            "circle", "square"
    };
    private int score;

    public SampleQuizGame(){
        super(R.layout.activity_game_sample_quiz);
        this.relatedMilestones = new Milestone[] {Milestone.CAN_NAME_MOST_FAMILIAR_THINGS};
    }

    @Override
    public void updateGameResults() {
        GameResult canNameMostFamiliarThings = new GameResult();

        canNameMostFamiliarThings.setRelatedMilestone(Milestone.CAN_NAME_MOST_FAMILIAR_THINGS);

        canNameMostFamiliarThings.setScore(score);

        gameResults.add(canNameMostFamiliarThings);
    }

    @Override
    public void bindToUserInterface() {
        TextView questionText = (TextView)findViewById(R.id.question);
        TextView scoreText = (TextView)findViewById(R.id.answer);

        Button answer1 = (Button)findViewById(R.id.answer1);
        Button answer2 = (Button) findViewById(R.id.answer2);
        Button answer3 = (Button) findViewById(R.id.answer3);
        Button answer4 = (Button) findViewById(R.id.answer4);

    }
}
