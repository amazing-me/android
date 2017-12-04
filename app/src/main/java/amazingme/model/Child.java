package amazingme.model;

import android.support.annotation.NonNull;
import android.util.Log;

import org.joda.time.LocalDate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import amazingme.util.DateAdapter;

public class Child extends User {

    private Sex sex;

    private long birthday;
    // leaving this as "game results" so other classes don't worry about it if they don't need to concern themselves about it
    // TODO -> also, thanks firebase for only letting me use strings as keys...
    private Map<String, List<GameResult>> gameResults;
    private List<KnownDevelopmentalDisabilities> knownDevelopmentalDisabilities;

    public Child() {
        super("", "");
        this.sex = null;
        this.knownDevelopmentalDisabilities = new LinkedList<>();
        this.birthday = -1;
        this.initGameResultMap();
    }

    public Child(String firstName, String lastName, Sex sex, LocalDate dob, List<KnownDevelopmentalDisabilities> knownDevelopmentalDisabilities) {
        this(firstName, lastName, sex, DateAdapter.convertLocalDateToMillis(dob), knownDevelopmentalDisabilities);
    }

    public Child(String firstName, String lastName, Sex sex, long dob, List<KnownDevelopmentalDisabilities> kdd) {
        super(firstName, lastName);
        this.sex = sex;
        this.birthday = dob;
        this.knownDevelopmentalDisabilities = kdd;
        this.initGameResultMap();
    }

    public enum Sex { //for health data, i'm decently sure gender preference isn't a factor, but we should clarify
        MALE,
        FEMALE;
    }
    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public long getBirthday() { return this.birthday; }

    public void setBirthday(long dateOfBirth) { this.birthday = dateOfBirth; }

    public Map<String, List<GameResult>> getGameResults() { return this.gameResults; }

    public void setGameResults(Map<String, List<GameResult>> map) {
        this.gameResults = map;
    }

    public List<KnownDevelopmentalDisabilities> getKnownDevelopmentalDisabilities() {
        return knownDevelopmentalDisabilities;
    }

    public void setKnownDevelopmentalDisabilities(List<KnownDevelopmentalDisabilities> knownDevelopmentalDisabilities) {
        this.knownDevelopmentalDisabilities = knownDevelopmentalDisabilities;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.birthday = DateAdapter.convertLocalDateToMillis(dateOfBirth);
    }

    public List<GameResult> getGameResultsCorrespondingTo(Milestone milestone) {
        return this.gameResults.get(milestone.toString());
    }

    public List<GameResult> listOfGameResults() {
        List<GameResult> fullGameList = new LinkedList<>();
        for (Milestone milestone : Milestone.values()) {
            fullGameList.addAll(this.gameResults.get(milestone.toString()));
        }
        return fullGameList;
    }

    public void addToGameResults(@NonNull final List<GameResult> results) {
        for (GameResult result : results) {
            if (this.gameResults.get(result.getRelatedMilestone().toString()) == null) {
                Log.e("add to game results", "game results map not instantiated for milestone");
                this.gameResults.put(result.getRelatedMilestone().toString(), new LinkedList<GameResult>());
            }
            this.gameResults.get(result.getRelatedMilestone().toString()).add(result);
        }
    }

    private void initGameResultMap() {
        this.gameResults = new HashMap<>();
        for (Milestone milestone : Milestone.values()) {
            this.gameResults.put(milestone.toString(), new LinkedList<GameResult>());
        }
    }
}
