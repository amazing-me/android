package amazingme.games;

public enum GameList {

    THREE_TOUCH_GAME("ThreeTouchGame", true);

    private String classname;
    private boolean isActive;

    GameList(String className, boolean isActive) {
        this.classname = className;
        this.isActive = isActive;
    }

    public static java.util.List<String> asStringList() {
        java.util.List<String> list = new java.util.ArrayList<>();
        for(GameList game : GameList.values()) {
            if(game.isActive)
            list.add(game.getClass().getName() + game.classname);
        }
        return list;
    }

    @Override
    public String toString() {
        return this.classname;
    }
}
