package amazingme.controller;

public interface LoginHandlingActivity {

    void handleLoginSuccess();

    void handleLoginFailure(Exception e);

}
