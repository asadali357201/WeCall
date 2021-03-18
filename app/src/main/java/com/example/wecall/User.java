package com.example.wecall;

public class User {
    String uid,name,PhoneNumber,userImage;
    public User(){

    }

    public User(String uid, String name, String phoneNumber, String userImage) {
        this.uid = uid;
        this.name = name;
        PhoneNumber = phoneNumber;
        this.userImage = userImage;
    }


    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }
}
