package amazingme.controller;

import amazingme.database.Session;

public interface ISessionLoginHandler {

    void onSessionLoginSuccess(Session session);

    void onSessionLoginFailure(Exception e);

}
