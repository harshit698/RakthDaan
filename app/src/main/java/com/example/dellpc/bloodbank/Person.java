package com.example.dellpc.bloodbank;

/**
 * Created by DELL PC on 27-Oct-17.
 */

public class Person {
    private String name;
    private String blood;
    public Person(String name, String blood){
        this.name=name;
        this.blood=blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }
}
