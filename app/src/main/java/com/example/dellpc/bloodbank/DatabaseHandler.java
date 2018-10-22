package com.example.dellpc.bloodbank;
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper{
    public DatabaseHandler(Context context, Object name,
                           Object factory, int version) {
        // TODO Auto-generated constructor stub
        super(context,  DATABASE_NAME, null, DATABASE_VERSION);
    }

    String password,mail;
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "new.db";

    // Contacts table name
    private static final String TABLE_REGISTER= "new_account";
    public static final String KEY_ID = "id";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL="email_id";
    public static final String KEY_DOB = "dob";
    public static final String KEY_NUMBER="number";
    public static final String KEY_SEX = "sex";
    public static final String KEY_BLOODGRP="BLOODGRP";
    public static final String KEY_DONOR="donor";

    public static final String CREATE_TABLE="CREATE TABLE " + TABLE_REGISTER + "("
            + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_PASSWORD + " TEXT,"+KEY_NAME + " TEXT,"+KEY_EMAIL+ " TEXT,"+KEY_DOB + " TEXT,"
            + KEY_NUMBER + " TEXT," + KEY_SEX + " TEXT," +KEY_BLOODGRP + " TEXT,"+KEY_DONOR+" TEXT"+ ")";

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER);

        // Create tables again
        onCreate(db);
    }

    void addregister(Registerdata registerdata)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_PASSWORD,registerdata.getPassword());
        values.put(KEY_NAME,registerdata.getname());
        values.put(KEY_EMAIL,registerdata.getemail());
        values.put(KEY_DOB,registerdata.getdob());
        values.put(KEY_NUMBER,registerdata.getnumber());
        values.put(KEY_SEX,registerdata.getsex());
        values.put(KEY_BLOODGRP,registerdata.getbloodgrp());
        values.put(KEY_DONOR,"0");
        db.insert(TABLE_REGISTER,null,values);
        db.close();
    }
    public Cursor getlistcontent(String bloodgrp){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM new_account WHERE donor=1 AND BLOODGRP=?",new String[]{bloodgrp+""});
        return cursor;
    }
    public Cursor getdetail(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM new_account",null);
        return cursor;
    }
    void updatedonor(String mail)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("donor","1");
        db.update("new_account",contentValues,"email_id=?",new String[]{mail});
        db.close();
    }
    void updatedonor1(String mail)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("donor","0");
        db.update("new_account",contentValues,"email_id=?",new String[]{mail});
        db.close();
    }
    String getregister(String username){
        SQLiteDatabase db = this.getReadableDatabase();
        //String selectquery="SELECT * FROM TABLE_REGISTER";
        Cursor cursor=db.query(TABLE_REGISTER,null,  "email_id=?",new String[]{username},null, null, null, null);

        if(cursor.getCount()<1){
            cursor.close();
            return "Not Exist";
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){

            password = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));
            cursor.close();

        }
        return password;
    }
    String checkifemailexists(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.query(TABLE_REGISTER,null,  "email_id=?",new String[]{email},null,null,null,null);
        if(cursor.getCount()<1){
            cursor.close();
            return "Not Exist";
        }
        else if(cursor.getCount()>=1 && cursor.moveToFirst()){

            mail = cursor.getString(cursor.getColumnIndex(KEY_EMAIL));
            cursor.close();

        }
        return mail;
    }
    String name(String user){
        String mail="";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT name FROM new_account WHERE email_id=?",new String[]{user+""});
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            mail=cursor.getString(cursor.getColumnIndex("name"));
        }
        return mail;
    }
    String dob(String user){
        String dob="";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT dob FROM new_account WHERE email_id=?",new String[]{user+""});
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            dob=cursor.getString(cursor.getColumnIndex("dob"));
        }
        return dob;
    }
    String mobile(String user){
        String phone="";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT number FROM new_account WHERE email_id=?",new String[]{user+""});
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            phone=cursor.getString(cursor.getColumnIndex("number"));
        }
        return phone;
    }
    String donor(String user){
        String dono="NIL";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT donor FROM new_account WHERE email_id=?",new String[]{user+""});
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            dono=cursor.getString(cursor.getColumnIndex("donor"));
        }
        return dono;
    }
    String sexx(String user){
        String gender="";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT sex FROM new_account WHERE email_id=?",new String[]{user+""});
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            gender=cursor.getString(cursor.getColumnIndex("sex"));
        }
        return gender;
    }
    String blood(String user){
        String bloodd="";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT BLOODGRP FROM new_account WHERE email_id=?",new String[]{user+""});
        if(cursor.getCount()>0){
            cursor.moveToFirst();
            bloodd=cursor.getString(cursor.getColumnIndex("BLOODGRP"));
        }
        return bloodd;
    }
    public void deleteUser(String mail) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query= "DELETE FROM "+TABLE_REGISTER+" WHERE "+KEY_EMAIL+" = '"+mail+"'";
        db.execSQL(query);
    }
    public String getDatabaseName() {
        return DATABASE_NAME;
    }

    public static String getKeyId() {
        return KEY_ID;
    }

    public static String getTableContacts() {
        return TABLE_REGISTER;
    }

    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }
}
