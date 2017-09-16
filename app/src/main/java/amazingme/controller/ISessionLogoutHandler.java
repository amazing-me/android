package amazingme.controller;

public interface ISessionLogoutHandler {

    void onSessionLogoutSuccess();

    void onSessionLogoutFailure(Exception e);

}
