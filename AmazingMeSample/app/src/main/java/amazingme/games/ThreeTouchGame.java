package amazingme.games;

import android.os.Bundle;

import amazingme.model.EnumeratedActivity;
import amazingme.model.AmazingMeGame;
import amazingme.model.GameResult;
import amazingme.model.Milestone;


//touch the screen three times within a minute to complete this.

public class ThreeTouchGame extends AmazingMeGame {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //TODO -> implement
    @Override
    public GameResult gameResults() {
        return null;
    }

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.THREE_TOUCH_GAME;
    }


    private Milestone[] relatedMilestones = {
            Milestone.FOLLOWS_INSTRUCTIONS
    };
}
