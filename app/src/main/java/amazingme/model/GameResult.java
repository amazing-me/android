package amazingme.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameResult implements Serializable {

    private int score;
    private List<Problem> problems;

    public GameResult() {
        this.score = 0;
        this.problems = new ArrayList<>();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public void addProblem(Problem problem) {
        problems.add(problem);
    }

}
