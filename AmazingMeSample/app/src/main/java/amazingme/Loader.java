package amazingme;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Constructor;

import amazingme.games.GameList;
import amazingme.games.ThreeTouchGame;
import amazingme.model.Game;

public class Loader {

    public Loader(){}


    public static void load(Consultant consultant) {
        //load data from the database and populate the babysitter info
        //can also load settings like which child was playing last or something
        //FIXME make sure this will load game classes correctly later... not completely sure at this moement.
        consultant.setAvailableGames(loadGames());
    }

    private static List<Game> loadGames() {
        //for each line in the file, trim whitespace and get the name of the class
        List<String> classNames = retrieveActiveGameNames();
        java.util.List<Game> games = new ArrayList<>();
        try {
            for (String className : classNames) {
                System.out.println("loading class " + className);
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

    private static List<Game> safeLoadGames() {
        List<Game> safeLoadList = new ArrayList<>();
        safeLoadList.add(new ThreeTouchGame());
        return safeLoadList;
    }

    private static List<String> retrieveActiveGameNames() {
        return GameList.asStringList();
    }

}
