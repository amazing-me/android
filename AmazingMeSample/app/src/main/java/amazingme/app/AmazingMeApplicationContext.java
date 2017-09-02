package amazingme.app;

import com.google.firebase.database.DataSnapshot;

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
        /*JSONObject jsonObject = loadAmazingMeContextFromDatabase(parentId);
        setParentUser(loadParentUserInformationFromContext(jsonObject));
        setChildrenUsers(loadChildrenUserInformationFromContext(jsonObject));
        setAvailableGames(loadAvailableGames(currentChildUser));
        setCurrentChildPlayer(0);*/
        //TODO -> probably need to make this happen with the loader... that way this class doesn't concern itself with HOW it does it, it just knows it happens.
        //TODO -> we can do that when we've saved/loaded a datasnapshot to play around with... but then changes only happen in loader, not every class that needs loading of data
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
    private static DataSnapshot loadAmazingMeContextFromDatabase(int parentId) {
        return null;
    }
    //TODO -> implement
    private static Parent loadParentUserInformationFromContext(DataSnapshot context) {
        return null;
    }
    //TODO -> implement
    private static List<Child> loadChildrenUserInformationFromContext(DataSnapshot context) {
        return null;
    }
    //TODO -> implement
    private static List<AmazingMeGame> loadAvailableGames(Child currentChildUser) {
        //passing the child so we know how to filter.
        return null;
    }

}
