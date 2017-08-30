package amazingme;

import java.util.List;

import amazingme.model.Child;
import amazingme.model.Game;
import amazingme.model.Parent;
import amazingme.model.User;


public class Babysitter {

    private static User parentUser;
    private static List<? extends User> children;

    private static User currentChildPlayer;
    private static Game[] availableGames; // shouldn't change unless the app is downloaded... fine to keep as array

    public static void setCurrentChildPlayers(int index) {
        currentChildPlayer = children.get(index);
    }

    public static void setParentUser(Parent parent) {
        parentUser = parent;
    }

    public static void setChildren(List<Child> childList) {
        children = childList;
    }

}
