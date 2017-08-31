package amazingme.games;

import amazingme.model.Game;
import amazingme.model.GameResult;
import amazingme.model.Milestone;
import amazingme.model.Problem;


//touch the screen three times within a minute to complete this.

public class ThreeTouchGame implements Game{

    private Milestone[] relatedMilestones = {
            Milestone.FOLLOWS_INSTRUCTIONS
    };

    @Override
    public void takeover() {
        //implement activity for game here
        //maybe save state of current activity here before moving on
    }

    @Override
    public GameResult resign(boolean gameWasCompleted) {
        //end activity you have (or clear data or whatever you need) and hand control back to the activity
        //you took control from

        //TODO -> END THE ACTIVITY AND GIVE BACK CONTROL

        if(gameWasCompleted) {
            return new GameResult(this.score(), this.problemAreas());
        } else {
            //if they didn't finish the game, return results that indicate that so we can either keep track or ignore them.
            return new GameResult(0, new Problem[] {Problem.DID_NOT_FINISH});
        }
    }

    @Override
    public void pause() {
        //this will stop the timer and make the screen stop changing (if it's changing);
    }

    @Override
    public void resume() {
        //resume the timer and make the game continue
    }

    @Override
    public void exitIncompleteGame() {
        this.resign(false);
    }

    @Override
    public void exitCompletedGame() {
        this.resign(true);
    }

    @Override
    public int score() {
        //have an intelligent way to score the performance
        return 0;
    }

    @Override
    public Problem[] problemAreas() {
        //note areas that caused the score to go down so the user knows how to improve the score
        return new Problem[0];
    }

    @Override
    public Milestone[] relatedMilestones() {
        return this.relatedMilestones;
    }
}
