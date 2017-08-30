package amazingme;

import java.util.List;

import amazingme.model.Child;
import amazingme.model.Game;
import amazingme.model.Parent;
import amazingme.model.User;


public class Consultant {

    private User parentUser;
    private List<? extends User> children;

    private User currentChildPlayer;
    private List<Game> availableGames; // shouldn't change unless the app is downloaded... fine to keep as array

    public void loadInformation() {
        if(informationNotLoaded()) {
            this.learn();
        }
        else {
            //do some stuff.
        }
    }

    public void setCurrentChildPlayers(int index) {
        currentChildPlayer = children.get(index);
    }

    public void setParentUser(Parent parent) {
        parentUser = parent;
    }

    public void setChildren(List<Child> childList) {
        children = childList;
    }

    public void setAvailableGames(List<Game> games) {
        availableGames = games;
    }

    public void learn() {
        Loader.load(this);
    }

    private boolean informationNotLoaded() {
        boolean notLoaded = false;
        return notLoaded;
    }

}
