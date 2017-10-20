package amazingme.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import amazingme.app.EnumeratedActivity;

public abstract class AmazingMeGame extends AmazingMeAppCompatActivity {

    protected Milestone[] relatedMilestones;
    protected List<GameResult> gameResults;
    private Timer timer;
    private TimerTask gameTask;

    private boolean started;
    private boolean paused;
    private int updatePeriod;

    public AmazingMeGame(int layout) {
        super(layout);

        this.gameResults = new LinkedList<>();
        this.timer = new Timer();
        this.gameTask = new TimerTask() {
            @Override
            public void run() {
                if(!paused) {
                    gameLogicUpdate();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            gameUIUpdate();
                        }
                    });
                }
            }
        };
    }

    public final void startGame(int updateRate) {
        if(started) {
            return;
        }

        timer.scheduleAtFixedRate(gameTask, updateRate, updateRate);

        this.started = true;
        this.updatePeriod = updateRate;
    }

    public final void resignGame(boolean gameWasCompleted) {
        timer.cancel();

        if (gameWasCompleted) {
            this.updateGameResults();
            this.addGameResultsToUserContext(gameResults);
        }
        goTo(EnumeratedActivity.GAME_MENU);
    }

    public final void pauseGame() {
        if(!paused) {
            paused = true;
        }
    }

    public final void unpauseGame() {
        if(paused) {
            paused = false;
        }
    }

    public final boolean isPaused() {
        return paused;
    }

    private void addGameResultsToUserContext(List<GameResult> gameResults) {
        // TODO should we make sure the length of the list is the same length as the related milestone array to force them to give data for everything?
        this.getUserContext().addGameResults(gameResults);
    }

    public abstract void updateGameResults();

    public abstract void gameLogicUpdate();

    public abstract void gameUIUpdate();

}
