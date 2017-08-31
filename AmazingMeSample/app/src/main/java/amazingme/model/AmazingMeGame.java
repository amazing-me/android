package amazingme.model;

import android.os.Bundle;
import amazingme.ActivityManager;

public abstract class AmazingMeGame extends AmazingMeAppCompatActivity implements AmazingMeGameCompatible {



    public final void resign(boolean gameWasCompleted) {
        Bundle gameResultsBundle = new Bundle();
        if(gameWasCompleted) {
            gameResultsBundle.putSerializable("GAME RESULTS BUNDLE", this.gameResults());
        } else {
            gameResultsBundle.putSerializable("GAME RESULTS BUNDLE", new GameResult(0, new Problem[] {Problem.DID_NOT_FINISH}));
        }
        //ActivityManager.getInstance().goTo(EnumeratedActivity.MAIN_MENU, gameResultsBundle);
    }

    public abstract GameResult gameResults();

    /*void exitIncompleteGame();

    void exitCompletedGame();

    int score(); //should have a good way to score each interaction

    Problem[] problemAreas(); //should implement finding problem areas that decreased score in each interaction

    Milestone[] relatedMilestones();*/

}
