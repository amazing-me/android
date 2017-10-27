package amazingme.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import amazingme.model.Child;
import amazingme.model.GameResult;
import amazingme.model.Parent;

public class UserContext {

    private Parent parent;
    private Map<Integer, Child> children; //not setting this as final because it could change in a session of using the app
    private int currentChildUser;

    public UserContext() {
        this(new Parent(), new HashMap<Integer, Child>());
    }

    public UserContext(Parent parent, Map<Integer, Child> children) {
        this.parent = parent;
        this.children = children;
        this.currentChildUser = 0;
    }

    public void addChild(Child child) {
        children.put(children.size(), child);
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Map<Integer, Child> getChildren() {
        return children;
    }

    public List<GameResult> getGameResultsForCurrentChildUser() {
        return this.getCurrentChildUser().getGameResults();
    }

    public void addGameResultsForCurrentChildUser(List<GameResult> newGameResults) {
        this.getCurrentChildUser().addToGameResults(newGameResults);
    }

    public void setCurrentChildUser(int currentChildUser) {
        this.currentChildUser = currentChildUser;
    }

    public Child getCurrentChildUser() { return this.children.get(currentChildUser); }
}
