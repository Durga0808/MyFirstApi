package com.testAPI.MyFirstAPI;

public class User {
    private int UserId;
    private String Name;
    private int Age;
    private String city;
    private String Email_ID;
    private int Mobile_No;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User() {
    }

    public User(int userId, String name, int age,String city, String email_ID, int mobile_No) {
        UserId = userId;
        Name = name;
        Age = age;
        city=city;
        Email_ID = email_ID;
        Mobile_No = mobile_No;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int id) {
        this.UserId = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public String getEmail_ID() {
        return Email_ID;
    }

    public void setEmail_ID(String email_ID) {
        this.Email_ID = email_ID;
    }

    public int getMobile_No() {
        return Mobile_No;
    }

    public void setMobile_No(int mobile_No) {
        this.Mobile_No = mobile_No;
    }
}
