package amazingme.games;

import android.os.Bundle;

import amazingme.model.EnumeratedActivity;
import amazingme.model.AmazingMeGame;
import amazingme.model.GameResult;


//touch the screen three times within a minute to complete this.

public class ThreeTouchGame extends AmazingMeGame {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        System.out.println("three touch game before super");
        super.onCreate(savedInstanceState);
        System.out.println("three touch game after super");
    }

//    private Milestone[] relatedMilestones = {
//            Milestone.FOLLOWS_INSTRUCTIONS
//    };
//
//    @Override
//    public void takeover() {
//        //implement activity for game here
//        //maybe save state of current activity here before moving on
//    }
//
//    @Override
//    public GameResult resign(boolean gameWasCompleted) {
//        //end activity you have (or clear data or whatever you need) and hand control back to the activity
//        //you took control from
//
//        //TODO -> END THE ACTIVITY AND GIVE BACK CONTROL
//
//        if(gameWasCompleted) {
//            return new GameResult(this.score(), this.problemAreas());
//        } else {
//            //if they didn't finish the game, return results that indicate that so we can either keep track or ignore them.
//            return new GameResult(0, new Problem[] {Problem.DID_NOT_FINISH});
//        }
//    }
//
//    @Override
//    public GameResult gameResults() {
//        return null;
//    }
//
//    @Override
//    public void pause() {
//        //this will stop the timer and make the screen stop changing (if it's changing);
//    }
//
//    @Override
//    public void resume() {
//        //resume the timer and make the game continue
//    }
//
//    @Override
//    public void exitIncompleteGame() {
//        this.resign(false);
//    }
//
//    @Override
//    public void exitCompletedGame() {
//        this.resign(true);
//    }
//
//    @Override
//    public int score() {
//        //have an intelligent way to score the performance
//        return 0;
//    }
//
//    @Override
//    public Problem[] problemAreas() {
//        //note areas that caused the score to go down so the user knows how to improve the score
//        return new Problem[0];
//    }
//
//    @Override
//    public Milestone[] relatedMilestones() {
//        return this.relatedMilestones;
//    }
//

    @Override
    public EnumeratedActivity activityName() {
        return EnumeratedActivity.THREE_TOUCH_GAME;
    }

    @Override
    public void resign() {
        System.out.println("Three Touch Game Resign");
    }

    @Override
    public GameResult gameResults() {
        return null;
    }
}
