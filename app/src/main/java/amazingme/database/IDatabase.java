package amazingme.database;

import com.google.firebase.database.DataSnapshot;

import amazingme.app.UserContext;

public interface IDatabase {

    void set(UserContext input);

    void update();

    void push();

    DataSnapshot get(); //TODO -> I don't like this being hard coded..... but do it for now.

    DataSnapshot getUserContext();

}
