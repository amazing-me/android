package amazingme.controller;

public interface RegistrationHandlingActivity {

    void handleRegistrationSuccess();

    void handleRegistrationFailure(final Exception exception);

}
