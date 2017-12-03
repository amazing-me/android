package amazingme.app;

public abstract class GameService<T extends GameService.Config> {

    public static abstract class Config { }

    private T config;
    private AmazingMeGame game;

    public GameService(T config, AmazingMeGame game) {
        this.config = config;
        this.game = game;
    }

    public T getConfig() {
        return config;
    }

    public AmazingMeGame getGame() {
        return game;
    }

    protected abstract void onGameInit();

    protected abstract void onGameStart();

    protected abstract void onGamePause();

    protected abstract void onGameUnpause();

    protected abstract void onGameResign();

}
