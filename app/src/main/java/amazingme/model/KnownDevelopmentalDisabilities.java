package amazingme.model;


public enum KnownDevelopmentalDisabilities {
    ADD,
    ADHD,
    AUTISM_SPECTRUM_DISORDER,
    CEREBRAL_PALSY,
    DOWN_SYNDROME,
    NONE;

    String commonName;
    String userInterfaceFillerName;
    int minimumAgeOfNoticeableSymptoms;
    int maximumAgeOfNoticeableSymptoms;

    KnownDevelopmentalDisabilities() {
        this(null, null, -1, -1);
    }

    KnownDevelopmentalDisabilities(String commonName, String userInterfaceFillerName, int minAge, int maxAge) {
        this.commonName = commonName;
        this.userInterfaceFillerName = userInterfaceFillerName;
        this.minimumAgeOfNoticeableSymptoms = minAge;
        this.maximumAgeOfNoticeableSymptoms = maxAge;
    }

    //TODO -> keep filling them up
    //TODO -> research on how they should affect our scores and performance modeling
}
