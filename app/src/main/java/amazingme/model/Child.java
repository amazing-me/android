package amazingme.model;

import java.util.List;

public class Child extends User {

    private final Sex sex;
    private final int age;
    private final List<KnownDevelopmentalDisabilities> knownDevelopmentalDisabilities;

    public Child(String firstName, String lastName, Sex sex, int age, List<KnownDevelopmentalDisabilities> knownDevelopmentalDisabilities, int userId) {
        //TODO -> do we need a check here...??
        super(firstName, lastName, userId);
        this.sex = sex;
        this.age = age;
        this.knownDevelopmentalDisabilities = knownDevelopmentalDisabilities;
    }

    public enum Sex { //for health data, i'm decently sure gender preference isn't a factor, but we should clarify
        MALE,
        FEMALE;
    }

}
