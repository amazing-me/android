package amazingme.app;

import java.util.List;

import amazingme.model.Child;
import amazingme.model.GameResult;
import amazingme.model.Parent;

public class UserContext {

    private final Parent parent;
    private List<Child> children; //not setting this as final because it could change in a session of using the app
    private List<GameResult> gameResults;


    public UserContext(Parent parent, List<Child> children, List<GameResult> gameResults) {
        this.parent = parent;
        this.children = children;
        this.gameResults = gameResults;
    }

}
