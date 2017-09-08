package amazingme.model;


public abstract class User {

    private final int userId;
    private final String firstName;
    private final String lastName;

    public User(String firstName, String lastName, int userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userId = userId;
    }

}
