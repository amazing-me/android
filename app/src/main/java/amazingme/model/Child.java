package amazingme.model;

import android.support.annotation.NonNull;

import org.joda.time.LocalDate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import amazingme.util.DateAdapter;

public class Child extends User {

    private Sex sex;

    private AmazingMeDate birthday;
    // leaving this as "game results" so other classes don't worry about it if they don't need to concern themselves about it
    private Map<Milestone, List<GameResult>> gameResults;
    private List<KnownDevelopmentalDisabilities> knownDevelopmentalDisabilities;

    public Child() {
        this.sex = null;
        this.knownDevelopmentalDisabilities = new LinkedList<>();
        this.birthday = null;
        this.birthday = null;
        this.gameResults = new HashMap<>();
    }

    public Child(String firstName, String lastName, Sex sex, LocalDate dob, List<KnownDevelopmentalDisabilities> knownDevelopmentalDisabilities) {
        //TODO -> do we need a check here...??
        super(firstName, lastName);
        this.sex = sex;
        this.birthday = DateAdapter.convertLocalDateToBirthday(dob);
        this.knownDevelopmentalDisabilities = knownDevelopmentalDisabilities;
        this.setDateOfBirth(dob.getYear(), dob.getMonthOfYear(), dob.getDayOfMonth());
        this.gameResults = new HashMap<>();
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

    public List<KnownDevelopmentalDisabilities> getKnownDevelopmentalDisabilities() {
        return knownDevelopmentalDisabilities;
    }

    public void setKnownDevelopmentalDisabilities(List<KnownDevelopmentalDisabilities> knownDevelopmentalDisabilities) {
        this.knownDevelopmentalDisabilities = knownDevelopmentalDisabilities;
    }

    private void setDateOfBirth(int year, int month, int day) {
        this.birthday = new AmazingMeDate(year, month, day);
    }

    public List<GameResult> getGameResultsCorrespondingTo(Milestone milestone) {
        return this.gameResults.get(milestone);
    }

    public List<GameResult> getGameResults() {
        List<GameResult> fullGameList = new LinkedList<>();
        for (Milestone milestone : this.gameResults.keySet()) {
            fullGameList.addAll(this.gameResults.get(milestone));
        }
        return fullGameList;
    }

    public void addToGameResults(@NonNull final List<GameResult> results) {
        for (GameResult result : results) {
            this.gameResults.get(result.getRelatedMilestone()).add(result);
        }
    }
}
