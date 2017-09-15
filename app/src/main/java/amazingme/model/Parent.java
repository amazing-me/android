package amazingme.model;


public class Parent extends User {

    //todo -> do we need to keep track of the email?
    private String email;
    private String primaryCarePhysicianEmail;
    private String primaryCarePhysicianPhoneNumber; // yes, a phone number is a String

    /*private void dialContactPhone(final String phoneNumber) {
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null))); TODO -> this might be useful later and it'll be referenced here so i'm leaving it here.
    }*/

    public Parent() {
    }

    public Parent(String firstName, String lastName, String email, String pcpEmail, String pcpPhone) {
        //TODO -> do we need a check here...??
        super(firstName, lastName);
        this.email = email;
        this.primaryCarePhysicianEmail = pcpEmail;
        this.primaryCarePhysicianPhoneNumber = pcpPhone;
}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrimaryCarePhysicianEmail() {
        return primaryCarePhysicianEmail;
    }

    public void setPrimaryCarePhysicianEmail(String primaryCarePhysicianEmail) {
        this.primaryCarePhysicianEmail = primaryCarePhysicianEmail;
    }

    public String getPrimaryCarePhysicianPhoneNumber() {
        return primaryCarePhysicianPhoneNumber;
    }

    public void setPrimaryCarePhysicianPhoneNumber(String primaryCarePhysicianPhoneNumber) {
        this.primaryCarePhysicianPhoneNumber = primaryCarePhysicianPhoneNumber;
    }

}
