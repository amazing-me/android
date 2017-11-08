package amazingme.util;

import com.google.firebase.database.DataSnapshot;

import java.util.HashSet;
import java.util.Set;

import amazingme.app.UserContext;
import amazingme.app.AmazingMeGame;

public class Loader {

    public Loader(){}

    public static UserContext loadUserContextUsingDatabaseSnapshot(DataSnapshot databaseSnapshot) {
        return databaseSnapshot.getValue(UserContext.class);
    }

    public static Set<AmazingMeGame> loadAvailableGamesUsingUserContext(UserContext userContext) {
        return new HashSet<>();
    }


    /*public static void loadAvailableGamesUsingUserContext(AmazingMeApplicationContext amazingMeApplicationContext) {
        //loadAvailableGamesUsingUserContext data from the database and populate the babysitter info
        //can also loadAvailableGamesUsingUserContext settings like which child was playing last or something
        //FIXME make sure this will loadAvailableGamesUsingUserContext game classes correctly later... not completely sure at this moement.
        amazingMeApplicationContext.setAvailableGames(loadGames());
    }

    private static List<AmazingMeGame> loadGames() {
        //for each line in the file, trim whitespace and get the name of the class
        List<String> classNames = retrieveActiveGameNames();
        java.util.List<AmazingMeGame> games = new ArrayList<>();
        try {
            for (String className : classNames) {
                System.out.println("loading class " + className);
                Class<?> c = Class.forName(className);
                Constructor<?> cons = c.getConstructor();
                Object object = cons.newInstance();
                games.add((AmazingMeGame) object);
            }
        } catch (Exception e) {
            System.out.println("Fix exception handling later");
        }
        return games;
    }

    private static List<AmazingMeGame> safeLoadGames() {
        List<AmazingMeGame> safeLoadList = new ArrayList<>();
        safeLoadList.add(new ThreeTouchGame());
        return safeLoadList;
    }

    private static List<String> retrieveActiveGameNames() {
        return EnumeratedActivity.activeGamesAsStringList();
    }*/

}
