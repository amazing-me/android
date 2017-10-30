package amazingme.model;

import java.util.LinkedList;
import java.util.List;

import amazingme.app.EnumeratedActivity;

public abstract class AmazingMeGame extends AmazingMeAppCompatActivity {

    protected Milestone[] relatedMilestones;
    protected List<GameResult> gameResults;

    public AmazingMeGame(int layout) {
        super(layout);
        this.gameResults = new LinkedList<>();
    }

    public final void resign(boolean gameWasCompleted) {
        if (gameWasCompleted) {
            this.updateGameResults();
            this.addGameResultsToUserContext(gameResults);
            this.getAppContext().saveUserContext();
        }
        goTo(EnumeratedActivity.GAME_MENU);
    }

    private void addGameResultsToUserContext(List<GameResult> gameResults) {
        // TODO should we make sure the length of the list is the same length as the related milestone array to force them to give data for everything?
        this.getUserContext().addGameResultsForCurrentChildUser(gameResults);
    }

    public abstract void updateGameResults();

}
