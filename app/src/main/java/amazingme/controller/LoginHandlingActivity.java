package amazingme.controller;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public interface LoginHandlingActivity {

    void handle(final Task<AuthResult> task);

}
