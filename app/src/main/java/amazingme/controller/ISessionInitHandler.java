package amazingme.controller;

import amazingme.database.Session;

public interface ISessionInitHandler {

    void onSessionInitSuccess(Session session);

    void onSessionInitFailure(Exception e);

}
