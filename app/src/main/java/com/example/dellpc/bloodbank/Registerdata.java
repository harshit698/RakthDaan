package com.example.dellpc.bloodbank;


public class Registerdata {
    int _id;
    String name;
    String dob;
    String number;
    String sex;
    String bloodgrp;
    String email_id;
    String donor;
    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}
    String password;
    public Registerdata(){}
    public Registerdata(String email_id,String name,String dob,String number,String sex,String bloodgrp,String donor){
        this.name=name;
        this.dob=dob;
        this.number=number;
        this.sex=sex;
        this.email_id=email_id;
        this.donor=donor;
        this.bloodgrp=bloodgrp;
    }
    public int getID(){
        return this._id;
    }
    public void setID(int id){
        this._id=id;
    }
    public String getname(){
        return name;
    }
    public void setname(String name){
        this.name=name;
    }
    public String getdob(){
        return dob;
    }
    public void setdob(String dob){
        this.dob=dob;
    }
    public String getnumber(){
        return number;
    }
    public void setnumber(String number){
        this.number=number;
    }
    public String getsex(){
        return sex;
    }
    public void setsex(String sex){
        this.sex=sex;
    }
    public String getbloodgrp(){
        return bloodgrp;
    }
    public void setbloodgrp(String bloodgrp){
        this.bloodgrp=bloodgrp;
    }
    public String getemail(){
        return email_id;
    }
    public void setemail(String email_id){
        this.email_id=email_id;
    }
    public String getDonor(){
        return donor;
    }
    public void setDonor(String donor){
        this.donor=donor;
    }
}
