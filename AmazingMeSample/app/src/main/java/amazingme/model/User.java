package amazingme.model;


public abstract class User {

    private int userId;
    private int age;
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName, int age, int userId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.userId = userId;
    }

}
