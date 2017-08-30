package amazingme.database;

import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by zacharyhalaby on 8/29/17.
 */

public class FireBase {

    //gonna keep this so we can more easily communicate with the firebase

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference = database.getReference("message");

    public FireBase(){
        System.out.println("HERE WE GO");
        reference.setValue("Hello, world");
    }

}
