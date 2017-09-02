package amazingme.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FireBase {

    //gonna keep this so we can more easily communicate with the firebase

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference = database.getReference("message");

    public FireBase(){
        System.out.println("HERE WE GO");
        reference.setValue("Hello, world");
    }

}
