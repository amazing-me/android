package amazingme.controller;

import amazingme.database.Session;

public interface ISessionRegisterHandler {

    void onSessionRegisterSuccess(Session session);

    void onSessionRegisterFailure(Exception e);

}