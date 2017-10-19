package amazingme.model;

import org.joda.time.LocalDate;

import java.util.LinkedList;
import java.util.List;

import amazingme.util.DateAdapter;

public class Child extends User {

    private Sex sex;

    // have to use these because somewhere in the depths of LocalDate there's an array being used... BUT LocalDate makes counting months way easier so i'm keeping it.
    private Birthday birthday;

    private List<KnownDevelopmentalDisabilities> knownDevelopmentalDisabilities;

    public Child() {
        this.sex = null;
        this.knownDevelopmentalDisabilities = new LinkedList<>();
        this.birthday = null;
    }

    public Child(String firstName, String lastName, Sex sex, LocalDate dob, List<KnownDevelopmentalDisabilities> knownDevelopmentalDisabilities) {
        //TODO -> do we need a check here...??
        super(firstName, lastName);
        this.sex = sex;
        this.birthday = DateAdapter.convertLocalDateToBirthday(dob);
        this.knownDevelopmentalDisabilities = knownDevelopmentalDisabilities;
        this.setDateOfBirth(dob.getYear(), dob.getMonthOfYear(), dob.getDayOfMonth());
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
        this.birthday = new Birthday(year, month, day);
    }

}
