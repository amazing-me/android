package amazingme.model;


public class Parent extends User {

    private final String email;
    private final String primaryCarePhysicianEmail;
    private final String primaryCarePhysicianPhoneNumber; // yes, a phone number is a String

    /*private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null))); TODO -> this might be useful later and it'll be referenced here so i'm leaving it here.
    }*/

    public Parent(String firstName, String lastName, String email, String pcpEmail, String pcpPhone, int userId) {
        //TODO -> do we need a check here...??
        super(firstName, lastName, userId);
        this.email = email;
        this.primaryCarePhysicianEmail = pcpEmail;
        this.primaryCarePhysicianPhoneNumber = pcpPhone;
    }

}
