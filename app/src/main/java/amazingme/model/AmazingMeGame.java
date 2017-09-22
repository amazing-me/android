package amazingme.model;

import android.os.Bundle;

import java.util.LinkedList;

import amazingme.app.EnumeratedActivity;

public abstract class AmazingMeGame extends AmazingMeAppCompatActivity {

    protected Milestone[] relatedMilestones;

    public AmazingMeGame(int layout) {
        super(layout);
    }

    public final void resign(boolean gameWasCompleted) {
        Bundle gameResultsBundle = new Bundle();
        if(gameWasCompleted) {
            gameResultsBundle.putSerializable("GAME RESULTS BUNDLE", this.gameResults());
        } else {
            gameResultsBundle.putSerializable("GAME RESULTS BUNDLE", new GameResult(0, new LinkedList<Problem>()));
        }
        goTo(EnumeratedActivity.MAIN_MENU);
    }

    public abstract GameResult gameResults();

}
