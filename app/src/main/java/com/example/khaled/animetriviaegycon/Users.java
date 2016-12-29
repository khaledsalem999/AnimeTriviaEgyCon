package com.example.khaled.animetriviaegycon;

/**
 * Created by hyhae on 12/29/2016.
 */

public class Users {
    private String email;
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Users(String eemail, String ID, String fname, String lname, String pNumber ){
        email=eemail;
        id=ID;
        firstName=fname;
        lastName=lname;
        phoneNumber=pNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
