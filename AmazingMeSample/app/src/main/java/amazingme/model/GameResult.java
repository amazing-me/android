package amazingme.model;

import java.util.Arrays;

public class GameResult {

    private int score;
    private Problem[] problemAreas;

    public GameResult(int score, Problem[] specifiedProblemAreas) {
        this.score = score;
        this.problemAreas = deepCopy(specifiedProblemAreas);
    }

    public int getScore() {
        return this.score;
    }

    public Problem[] getProblemAreas() {
        return deepCopy(this.problemAreas);
    }

    private Problem[] deepCopy(Problem[] original) {
        Problem[] copy = new Problem[original.length];
        for(int i = 0; i < original.length; i++) { //this might be slow but the data transferred should always be small
            copy[i] = original[i];
        }
        return copy;
    }
}
