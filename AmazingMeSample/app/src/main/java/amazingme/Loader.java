package amazingme;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Constructor;

import amazingme.games.GameList;
import amazingme.model.Game;

public class Loader {

    public Loader(){}

    public static void LoadInitialData(Babysitter babysitter) {
        //load data from the database and populate the babysitter info
        //can also load settings like which child was playing last or something
    }

    private static List<Game> loadGames() {
        //for each line in the file, trim whitespace and get the name of the class
        List<String> classNames = retrieveActiveGameNames();
        java.util.List<Game> games = new ArrayList<>();
        try {
            for (String className : classNames) {
                Class<?> c = Class.forName(className);
                Constructor<?> cons = c.getConstructor();
                Object object = cons.newInstance();
                games.add((Game) object);
            }
        } catch (Exception e) {
            System.out.println("Fix exception handling later");
        }
        return games;
    }

    private static List<String> retrieveActiveGameNames() {
        return GameList.asStringList();
    }

}
