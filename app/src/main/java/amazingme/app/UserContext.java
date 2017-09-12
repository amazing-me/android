package amazingme.app;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import amazingme.model.Child;
import amazingme.model.GameResult;
import amazingme.model.Parent;

public class UserContext {

    public Parent parent;
    public HashMap<Integer, Child> children; //not setting this as final because it could change in a session of using the app
    public List<GameResult> gameResults;
    public int currentChildUser;

    public UserContext() {
        this(null, new LinkedHashMap<Integer, Child>(), new LinkedList<GameResult>());
    }

    public UserContext(Parent parent, HashMap<Integer, Child> children, List<GameResult> gameResults) {
        this.parent = parent;
        this.children = children;
        this.gameResults = gameResults;
        this.currentChildUser = 0;
    }

}
