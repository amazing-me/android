package amazingme;

import org.json.JSONObject;

import java.util.List;

import amazingme.model.Child;
import amazingme.model.AmazingMeGame;
import amazingme.model.Parent;
import amazingme.model.User;


public class AmazingMeApplicationContext {

    private static User parentUser;
    private static List<Child> children;
    private static Child currentChildUser;

    private static List<AmazingMeGame> availableGames;

    public static void loadContext(int parentId) {
        JSONObject jsonObject = loadAmazingMeContextFromDatabase(parentId);
        setParentUser(loadParentUserInformationFromContext(jsonObject));
        setChildrenUsers(loadChildrenUserInformationFromContext(jsonObject));
        setAvailableGames(loadAvailableGames(currentChildUser));
        setCurrentChildPlayer(0);
    }

    private static void setCurrentChildPlayer(int index) {
        currentChildUser = children.get(index);
    }

    private static void setParentUser(Parent parent) {
        parentUser = parent;
    }

    private static void setChildrenUsers(List<Child> childList) {
        children = childList;
    }

    private static void setAvailableGames(List<AmazingMeGame> games) {
        availableGames = games;
    }
    //TODO -> implement
    private static JSONObject loadAmazingMeContextFromDatabase(int parentId) {
        return null;
    }
    //TODO -> implement
    private static Parent loadParentUserInformationFromContext(JSONObject context) {
        return null;
    }
    //TODO -> implement
    private static List<Child> loadChildrenUserInformationFromContext(JSONObject context) {
        return null;
    }
    //TODO -> implement
    private static List<AmazingMeGame> loadAvailableGames(Child currentChildUser) {
        //passing the child so we know how to filter.
        return null;
    }

}
