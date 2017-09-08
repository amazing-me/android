package amazingme.model;


public abstract class User {

    private final String userId;
    private final String firstName;
    private final String lastName;

    public User(String firstName, String lastName, String userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
    }

}
