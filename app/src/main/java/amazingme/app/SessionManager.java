package amazingme.app;

import android.app.Activity;
import android.content.Context;

public interface SessionManager {

    boolean load(String email, String password, Context context);

    boolean end();

    boolean create(String email, String password, Context context);

    boolean isActive();
}
