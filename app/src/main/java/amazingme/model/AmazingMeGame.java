package amazingme.model;

import android.os.Bundle;
import amazingme.app.EnumeratedActivity;

public abstract class AmazingMeGame extends AmazingMeAppCompatActivity {

    protected Milestone[] relatedMilestones;

    public final void resign(boolean gameWasCompleted) {
        Bundle gameResultsBundle = new Bundle();
        if(gameWasCompleted) {
            gameResultsBundle.putSerializable("GAME RESULTS BUNDLE", this.gameResults());
        } else {
            gameResultsBundle.putSerializable("GAME RESULTS BUNDLE", new GameResult(0, new Problem[] {Problem.DID_NOT_FINISH}));
        }
        goTo(EnumeratedActivity.MAIN_MENU);
    }

    public abstract GameResult gameResults();

}
