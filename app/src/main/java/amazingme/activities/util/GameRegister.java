package amazingme.activities.util;

import java.util.LinkedList;
import java.util.List;

import amazingme.activities.games.ThreeTouchGame;
import amazingme.app.AmazingMeApplicationContext;
import amazingme.model.AmazingMeGame;

public class GameRegister {
    public static void registerGames(AmazingMeApplicationContext appContext) {
        List<Class<? extends AmazingMeGame>> games = new LinkedList<>();
        addGames(games);
        appContext.setGames(games);
    }

    // Add new game classes here, following the same format
    private static void addGames(List<Class<? extends AmazingMeGame>> games) {
        games.add(ThreeTouchGame.class);
        // games.add(NewGame.class);
    }
}
