package amazingme.app;

import amazingme.controller.LoginHandlingActivity;
import amazingme.controller.RegistrationHandlingActivity;

public interface SessionManager {

    void login(final String email, final String password, final LoginHandlingActivity handler);

    void logout();

    boolean isActive();
}
