package amazingme.app;

import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimerService extends GameService<GameTimerService.Config> {

    public static class Config extends GameService.Config {

        private int startTime;
        private int secondsTextId;
        private Runnable onFinish;

        public Config(int startTime, int secondsTextId, Runnable onFinish) {
            this.startTime = startTime;
            this.secondsTextId = secondsTextId;
            this.onFinish = onFinish;
        }

    }

    private int seconds;
    private Timer timer;
    private TimerTask timerTask;

    public GameTimerService(final Config config, final AmazingMeGame game) {
        super(config, game);

        final TextView secondsText = (TextView) game.findViewById(config.secondsTextId);

        seconds = config.startTime;
        timer = new Timer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                if(!game.isPaused()) {
                    seconds--;

                    if(seconds == 0) {
                        config.onFinish.run();
                    } else {
                        game.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                secondsText.setText(String.format("%d second%s",
                                    seconds, seconds != 1 ? "s" : ""));
                            }
                        });
                    }
                }
            }
        };
    }

    @Override
    protected void onGameInit() {
    }

    @Override
    protected void onGameStart() {
        timer.schedule(timerTask, 1000, 1000);
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

    public int getSeconds() {
        return seconds;
    }

}
