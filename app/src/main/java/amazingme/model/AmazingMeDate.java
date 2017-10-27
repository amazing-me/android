package amazingme.model;

public class AmazingMeDate {

    private int birthMonth;
    private int birthDay;
    private int birthYear;

    public AmazingMeDate(int year, int month, int day) {
        this.birthYear = year;
        this.birthMonth = month;
        this.birthDay = day;
    }

    public int getBirthMonth() { return this.birthMonth; }

    public int getBirthDay() { return this.birthDay; }

    public int getBirthYear() { return this.birthYear; }


}
