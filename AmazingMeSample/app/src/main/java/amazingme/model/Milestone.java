package amazingme.model;

public enum Milestone {

    FOLLOWS_INSTRUCTIONS("milestone 1 descriptioin", 2, 4),
    MILESTONE_2;

    int appropriateAgeMinimum;
    int appropriateAgeMaximum;
    String descriptor;

    Milestone(String description, int minAge, int maxAge) {
        this.descriptor = description;
        this.appropriateAgeMinimum = minAge;
        this.appropriateAgeMaximum = maxAge;
    }

    Milestone() {
        this("no description available", 0, 0);
    }

}
