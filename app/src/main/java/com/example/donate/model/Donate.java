package com.example.donate.model;

public class Donate {
    private String name;
    private int gender;
    private String city;
    private String time;
    private String date;
    private int donate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDonate() {
        return donate;
    }

    public void setDonate(int donate) {
        this.donate = donate;
    }

    public Donate(String name, int gender, String city, String time, String date, int donate) {
        this.name = name;
        this.gender = gender;
        this.city = city;
        this.time = time;
        this.date = date;
        this.donate = donate;
    }
}
