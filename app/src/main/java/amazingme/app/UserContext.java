package amazingme.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import amazingme.model.Child;
import amazingme.model.GameResult;
import amazingme.model.Parent;

public class UserContext {

    private Parent parent;
    private Map<String, Child> children; //not setting this as final because it could change in a session of using the app
    private int currentChildUser;

    public UserContext() {
        this(new Parent(), new HashMap<String, Child>());
    }

    public UserContext(Parent parent, Map<String, Child> children) {
        this.parent = parent;
        this.children = children;
        this.currentChildUser = 0;
    }

    public void addChild(Child child) {
        children.put(String.valueOf(children.size()), child);
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Map<String, Child> getChildren() {
        return children;
    }

    public void setChildren(Map<String, Child> children) { this.children = children; }

    public void setCurrentChildUser(int currentChildUser) {
        this.currentChildUser = currentChildUser;
    }

    public int getCurrentChildUser() {return this.currentChildUser; }

     public Child currentChildUser() { return this.children.get(String.valueOf(currentChildUser)); }

    public void addGameResultsForCurrentChildUser(List<GameResult> newGameResults) {
        this.currentChildUser().addToGameResults(newGameResults);
    }
}
