package amazingme.app;

import java.util.LinkedList;
import java.util.List;

import amazingme.model.Child;
import amazingme.model.GameResult;
import amazingme.model.Parent;

public class UserContext {

    private Parent parent;
    private List<Child> children; //not setting this as final because it could change in a session of using the app
    private List<GameResult> gameResults;
    private int currentChildUser;

    public UserContext() {
        this(new Parent(), new LinkedList<Child>(), new LinkedList<GameResult>());
    }

    public UserContext(Parent parent, List<Child> children, List<GameResult> gameResults) {
        this.parent = parent;
        this.children = children;
        this.gameResults = gameResults;
        this.currentChildUser = 0;
    }

    public void addChild(Child child) {
        children.add(child);
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public List<Child> getChildren() {
        return children;
    }

    public List<GameResult> getGameResults() {
        return gameResults;
    }

    public void setGameResults(List<GameResult> gameResults) {
        this.gameResults = gameResults;
    }

    public void addGameResults(List<GameResult> newGameResults) { this.gameResults.addAll(newGameResults);}

    public int getCurrentChildUser() {
        return currentChildUser;
    }

    public void setCurrentChildUser(int currentChildUser) {
        this.currentChildUser = currentChildUser;
    }
}
