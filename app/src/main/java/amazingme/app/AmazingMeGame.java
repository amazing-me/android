package amazingme.app;

import android.util.Log;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import amazingme.model.GameResult;

public abstract class AmazingMeGame extends AmazingMeAppCompatActivity {

    protected List<GameResult> gameResults;
    private Map<Class<?>, GameService> services;

    private boolean started;
    private boolean paused;

    public AmazingMeGame(int layout) {
        super(layout);

        this.gameResults = new LinkedList<>();
        this.services = new HashMap<>();
    }

    @Override
    public void bindToUserInterface() {
        initGame();

        for(GameService service : services.values()) {
            service.onGameInit();
        }
    }

    // Java generics make me cry
    public <C extends GameService.Config, S extends GameService<C>> S getService(Class<S> clazz, C config) {
        if(services.containsKey(clazz)) {
            Log.e(getClass().getName(), "tried to add service more than once");
            return null;
        }

        try {
            S service = clazz.getConstructor(config.getClass(), AmazingMeGame.class).newInstance(config, this);
            services.put(clazz, service);

            return service;
        } catch(Exception e) {
            // Some error recovery?
            Log.e(getClass().getName(), "failed to build service", e);
            return null;
        }
    }

    public final void startGame() {
        if(started) {
            return;
        }

        this.started = true;

        for(GameService service : services.values()) {
            service.onGameStart();
        }
    }

    public final void resignGame(boolean gameWasCompleted) {
        for(GameService service : services.values()) {
            service.onGameResign();
        }

        if (gameWasCompleted) {
            this.updateGameResults();
            this.addGameResultsToUserContext(gameResults);
            this.getAppContext().saveUserContext();
        }

        goTo(EnumeratedActivity.GAME_MENU);
    }

    public final void pauseGame() {
        if(paused) {
            return;
        }

        paused = true;

        for(GameService service : services.values()) {
            service.onGamePause();
        }
    }

    public final void unpauseGame() {
        if(!paused) {
            return;
        }

        paused = false;

        for(GameService service : services.values()) {
            service.onGamePause();
        }
    }

    public final boolean isPaused() {
        return paused;
    }

    private void addGameResultsToUserContext(List<GameResult> gameResults) {
        // TODO should we make sure the length of the list is the same length as the related milestone array to force them to give data for everything?
        this.getUserContext().addGameResultsForCurrentChildUser(gameResults);
    }

    public abstract void updateGameResults();

    public abstract void initGame();

}
