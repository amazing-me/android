package amazingme.app;

import amazingme.controller.LoginHandlingActivity;
import amazingme.controller.RegistrationHandlingActivity;

public interface SessionManager {

    void load(final String email, final String password, final LoginHandlingActivity handler);

    void end();

    void create(final String email, final String password, final RegistrationHandlingActivity handler);

    boolean isActive();
}
