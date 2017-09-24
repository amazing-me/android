package amazingme.model;

import java.util.List;

public class Child extends User {

    private Sex sex;
    private int age;
    private List<KnownDevelopmentalDisabilities> knownDevelopmentalDisabilities;

    public Child(String firstName, String lastName, Sex sex, int age, List<KnownDevelopmentalDisabilities> knownDevelopmentalDisabilities) {
        //TODO -> do we need a check here...??
        super(firstName, lastName);
        this.sex = sex;
        this.age = age;
        this.knownDevelopmentalDisabilities = knownDevelopmentalDisabilities;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<KnownDevelopmentalDisabilities> getKnownDevelopmentalDisabilities() {
        return knownDevelopmentalDisabilities;
    }

    public void setKnownDevelopmentalDisabilities(List<KnownDevelopmentalDisabilities> knownDevelopmentalDisabilities) {
        this.knownDevelopmentalDisabilities = knownDevelopmentalDisabilities;
    }
}
