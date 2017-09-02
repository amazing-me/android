package amazingme.model;

import android.content.Intent;
import android.os.Bundle;

import amazingme.activities.app.MainMenu;

public abstract class AmazingMeGame extends AmazingMeAppCompatActivity {

    protected Milestone[] relatedMilestones;

    public final void resign(boolean gameWasCompleted) {
        Bundle gameResultsBundle = new Bundle();
        if(gameWasCompleted) {
            gameResultsBundle.putSerializable("GAME RESULTS BUNDLE", this.gameResults());
        } else {
            gameResultsBundle.putSerializable("GAME RESULTS BUNDLE", new GameResult(0, new Problem[] {Problem.DID_NOT_FINISH}));
        }
        //ActivityManager.getInstance().goTo(EnumeratedActivity.MAIN_MENU, gameResultsBundle);
        Intent backToGameSelection = new Intent(getApplicationContext(), MainMenu.class); //this should be the game screen glass later
        startActivity(backToGameSelection); // this is technically resuming, but i don't believe it's important.
    }

    public abstract GameResult gameResults();

}
