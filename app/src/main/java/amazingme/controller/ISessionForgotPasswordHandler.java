package amazingme.controller;

public interface ISessionForgotPasswordHandler {

    void onSessionForgotPasswordSuccess();

    void onSessionForgotPasswordFailure(Exception e);

}
