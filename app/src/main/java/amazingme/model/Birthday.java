package amazingme.model;

public class Birthday {

    private int birthMonth;
    private int birthDay;
    private int birthYear;

    public Birthday(int year, int month, int day) {
        this.birthYear = year;
        this.birthMonth = month;
        this.birthDay = day;
    }

    public int getBirthMonth() { return this.birthMonth; }

    public int getBirthDay() { return this.birthDay; }

    public int getBirthYear() { return this.birthYear; }


}
