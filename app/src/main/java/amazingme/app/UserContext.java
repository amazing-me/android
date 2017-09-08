package amazingme.app;

import java.util.HashMap;
import java.util.List;

import amazingme.model.Child;
import amazingme.model.GameResult;
import amazingme.model.Parent;

public class UserContext {

    private final Parent parent;
    private HashMap<Integer, Child> children; //not setting this as final because it could change in a session of using the app
    private List<GameResult> gameResults;
    private int currentChildUser;

    public UserContext() {
        this(null, null, null);
    }

    public UserContext(Parent parent, HashMap<Integer, Child> children, List<GameResult> gameResults) {
        this.parent = parent;
        this.children = children;
        this.gameResults = gameResults;
        this.currentChildUser = 0;
    }

}
