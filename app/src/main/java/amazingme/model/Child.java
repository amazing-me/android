package amazingme.model;

import org.joda.time.LocalDate;
import org.joda.time.Months;

import java.util.LinkedList;
import java.util.List;

public class Child extends User {

    private Sex sex;
    private int ageInMonths;

    // have to use these because somewhere in the depths of LocalDate there's an array being used... BUT LocalDate makes counting months way easier so i'm keeping it.  
    private int year;
    private int month;
    private int day;


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
        this.setDateOfBirth(dob.getYear(), dob.getMonthOfYear(), dob.getDayOfMonth());
    }

    public enum Sex { //for health data, i'm decently sure gender preference isn't a factor, but we should clarify
        MALE,
        FEMALE;
    }

    public void setYear(int year) { this.year = year; }

    public void setMonth(int month) { this.year = month; }

    public void setDay(int day) { this.year = day; }

    public int getYear() { return this.year; }

    public int getMonth() { return this.month; }

    public int getDay() { return this.day; }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAgeInMonths() {
        this.updateAge();           // when we load in the date of birth isn't set. so we make sure it's set and adjust anytime we report the age in the rest of the app
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

    private void setDateOfBirth(int year, int month, int day) {
        this.dateOfBirth = new LocalDate(year, month, day);
        this.updateAge();
    }

    private LocalDate getDateOfBirth() { return this.dateOfBirth; }

    private void updateAge() {
        LocalDate now = new LocalDate();
        if (this.dateOfBirth == null) { //we haven't set it yet, perhaps because of loading from the database
            this.dateOfBirth = new LocalDate(this.year, this.month, this.day);
        }
        this.ageInMonths = Months.monthsBetween(this.dateOfBirth, now).getMonths();
    }
}
