package amazingme.database.firebase;

import com.google.firebase.auth.FirebaseUser;

import amazingme.database.ISession;

public class FirebaseSession implements ISession {

    private FirebaseUser user;

    public FirebaseSession(FirebaseUser user) {
        this.user = user;
    }

    @Override
    public String getDisplayName() {
        return user.getDisplayName();
    }

    @Override
    public String getEmail() {
        return user.getEmail();
    }

    public FirebaseUser getFirebaseUser() {
        return user;
    }

}
