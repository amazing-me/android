package amazingme.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class GameResult implements Serializable {

    private int score;
    private List<Problem> problemAreas;

    public GameResult() {
    }

    public GameResult(int score, List<Problem> specifiedProblemAreas) {
        this.score = score;
        this.problemAreas = specifiedProblemAreas;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Problem> getProblemAreas() {
        return problemAreas;
    }

    public void setProblemAreas(List<Problem> problemAreas) {
        this.problemAreas = problemAreas;
    }
}
