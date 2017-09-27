package amazingme.model;

import org.joda.time.LocalDate;
import org.joda.time.Months;

import java.util.LinkedList;
import java.util.List;

public class Child extends User {

    private Sex sex;
    private int ageInMonths;
    private LocalDate dateOfBirth;
    private List<KnownDevelopmentalDisabilities> knownDevelopmentalDisabilities;

    public Child() {
        this.sex = null;
        this.ageInMonths = -1;
        this.knownDevelopmentalDisabilities = new LinkedList<>();
        this.dateOfBirth = null;
    }

    public Child(String firstName, String lastName, Sex sex, LocalDate dob, List<KnownDevelopmentalDisabilities> knownDevelopmentalDisabilities) {
        //TODO -> do we need a check here...??
        super(firstName, lastName);
        this.sex = sex;
        this.dateOfBirth = dob;
        this.knownDevelopmentalDisabilities = knownDevelopmentalDisabilities;
        this.updateAge();
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

    public int getAgeInMonths() {
        return ageInMonths;
    }

    public void setAgeInMonths(int ageInMonths) {
        this.ageInMonths = ageInMonths;
    }

    public List<KnownDevelopmentalDisabilities> getKnownDevelopmentalDisabilities() {
        return knownDevelopmentalDisabilities;
    }

    public void setKnownDevelopmentalDisabilities(List<KnownDevelopmentalDisabilities> knownDevelopmentalDisabilities) {
        this.knownDevelopmentalDisabilities = knownDevelopmentalDisabilities;
    }

    public void setDateOfBirth(LocalDate dob) {
        this.dateOfBirth = dob;
        this.updateAge();
    }

    public LocalDate getDateOfBirth() { return this.dateOfBirth; }

    public void updateAge() {
        LocalDate now = new LocalDate();
        this.ageInMonths = Months.monthsBetween(this.dateOfBirth, now).getMonths();
    }
}
