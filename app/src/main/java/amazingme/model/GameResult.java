package amazingme.model;

import org.joda.time.LocalDate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameResult implements Serializable {

    private int score;
    private List<Problem> problems;
    private Milestone relatedMilestone;
    private long timestamp;


    public GameResult() {
        this(Milestone.NONE, 0, new LinkedList<Problem>());
    }

    public GameResult(Milestone relatedMilestone, int score, List<Problem> problems) {
        this.relatedMilestone = relatedMilestone;
        this.score = score;
        this.problems = problems;
        this.timestamp = System.currentTimeMillis();
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

    public void setRelatedMilestone(Milestone newMilestone) { this.relatedMilestone = newMilestone; }

    public Milestone getRelatedMilestone() { return this.relatedMilestone; }

    public long getTimestamp() { return this.timestamp; }

    public void setTimestamp(long time) { this.timestamp = time; } // i don't see a need for this except for firebase use, so it's here

}
