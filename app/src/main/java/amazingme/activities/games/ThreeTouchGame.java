package amazingme.activities.games;

import amazingme.app.EnumeratedActivity;
import amazingme.model.AmazingMeGame;
import amazingme.model.GameResult;
import amazingme.model.Milestone;


//touch the screen three times within a minute to complete this.

public class ThreeTouchGame extends AmazingMeGame {

    public ThreeTouchGame() {
        this.relatedMilestones = new Milestone[] {Milestone.UNDERSTANDS_WORDS_LIKE_IN_ON_AND_UNDER};
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

    @Override
    public void bindToUserInterface() {

    }

}
