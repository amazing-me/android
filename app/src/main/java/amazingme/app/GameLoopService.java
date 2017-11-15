package amazingme.app;

import java.util.Timer;
import java.util.TimerTask;

public class GameLoopService extends GameService<GameLoopService.Config> {

    public static class Config extends GameService.Config {

        private int updateRateMs;
        private Runnable logicUpdate;
        private Runnable uiUpdate;

        public Config(int updateRateMs, Runnable logicUpdate, Runnable uiUpdate) {
            this.updateRateMs = updateRateMs;
            this.logicUpdate = logicUpdate;
            this.uiUpdate = uiUpdate;
        }

    }

    private Timer timer;
    private TimerTask timerTask;

    public GameLoopService(final Config config, final AmazingMeGame game) {
        super(config, game);

        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                if(!game.isPaused()) {
                    config.logicUpdate.run();
                    game.runOnUiThread(config.uiUpdate);
                }
            }
        };
    }

    @Override
    protected void onGameInit() {
    }

    @Override
    protected void onGameStart() {
        timer.schedule(timerTask, getConfig().updateRateMs, getConfig().updateRateMs);
    }

    @Override
    protected void onGamePause() {
    }

    @Override
    protected void onGameUnpause() {
    }

    @Override
    protected void onGameResign() {
        timer.cancel();
    }

}
