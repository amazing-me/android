package amazingme.games;

import amazingme.model.EnumeratedActivity;

public enum GameList {

    THREE_TOUCH_GAME("ThreeTouchGame", true);

    private String classname;
    private boolean isActive;
    private final String PACKAGE_NAME = "amazingme.games.";
    private EnumeratedActivity enumeratedActivity;

    GameList(String className, boolean isActive) {
        this.classname = PACKAGE_NAME + className;
        this.isActive = isActive;
    }

    public static java.util.List<String> asStringList() {
        java.util.List<String> list = new java.util.ArrayList<>();
        for(GameList game : GameList.values()) {
            if(game.isActive) { //don't worry about non-active games... unless maybe for beta users??
                list.add(game.classname);
            }
        }
        return list;
    }

    @Override
    public String toString() {
        return this.classname;
    }

    public EnumeratedActivity getActivityName() {
        return this.enumeratedActivity;
    }
}
