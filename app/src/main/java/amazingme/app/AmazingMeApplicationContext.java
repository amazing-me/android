package amazingme.app;

import android.app.Application;

import com.google.android.gms.tasks.Task;

import amazingme.controller.ISessionForgotPasswordHandler;
import amazingme.controller.ISessionLoginHandler;
import amazingme.controller.ISessionLogoutHandler;
import amazingme.controller.ISessionRegisterHandler;
import amazingme.database.Session;
import amazingme.database.SessionManager;
import amazingme.database.firebase.FirebaseSessionManager;

public class AmazingMeApplicationContext extends Application {

    private SessionManager<? extends Session> sessionManager;

    @Override
    public void onCreate() {
        super.onCreate();

        sessionManager = new FirebaseSessionManager();
    }

    public UserContext getUserContext() {
        return sessionManager.getSession().getUserContext();
    }

    public Task<Void> saveUserContext() {
        return sessionManager.getSession().saveContext();
    }

    public void sessionInitialize(final ISessionLoginHandler handler) {
        sessionManager.initialize(handler);
    }

    public void sessionLogin(String email, String pass, final ISessionLoginHandler handler) {
        sessionManager.login(email, pass, handler);
    }

    public void sessionRegister(String email, String pass, final ISessionRegisterHandler handler) {
        sessionManager.register(email, pass, handler);
    }

    public void sessionLogout(final ISessionLogoutHandler handler) {
        sessionManager.logout(handler);
    }

    public void sessionForgotPassword(final ISessionForgotPasswordHandler handler, String email) {
        sessionManager.forgotPassword(handler, email);
    }

    public boolean hasSession() {
        return sessionManager.hasSession();
    }

}
