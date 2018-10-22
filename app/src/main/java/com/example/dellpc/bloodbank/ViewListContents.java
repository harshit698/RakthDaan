package com.example.dellpc.bloodbank;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class ViewListContents extends Activity {
    DatabaseHandler db;
    ProgressDialog progressDialog,progressDialog1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.viewcontent_layout);
        progressDialog = new ProgressDialog(ViewListContents.this);
        progressDialog1 = new ProgressDialog(ViewListContents.this);
        final ListView listview=(ListView)findViewById(R.id.listview);
        String bloodgrp=getIntent().getStringExtra("bloodgrp");
        db=new DatabaseHandler(ViewListContents.this,null,null,1);
        final ArrayList<Person> dolist=new ArrayList<>();
        final ArrayList<String> doinfo=new ArrayList<>();
        progressDialog1.setMessage("Fetching donor's...");
        progressDialog1.show();
        if(bloodgrp.equals("O+")){

            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo(bloodgrp)
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("O-")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
        }
        else if(bloodgrp.equals("O-")){
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo(bloodgrp)
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
        }
        else if(bloodgrp.equals("A+")){
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo(bloodgrp)
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("A-")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("O+")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("O-")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
        }
        else if(bloodgrp.equals("A-")){
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo(bloodgrp)
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("O-")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
        }
        else if(bloodgrp.equals("B+")){
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo(bloodgrp)
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("B-")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("O+")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("O-")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
        }
        else if(bloodgrp.equals("B-")){
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo(bloodgrp)
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            dolist.clear();
                            doinfo.clear();
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("O-")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
        }
        else if(bloodgrp.equals("AB+")){
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo(bloodgrp)
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            dolist.clear();
                            doinfo.clear();
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("O+")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("A+")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("A-")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("B+")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("B-")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("AB-")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("O-")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
        }
        else if(bloodgrp.equals("AB-")){
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo(bloodgrp)
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            dolist.clear();
                            doinfo.clear();
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("A-")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("B-")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
            FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("bloodgrp").equalTo("O-")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                                String name=snapshot.child("name").getValue(String.class);
                                String blood=snapshot.child("bloodgrp").getValue(String.class);
                                String mail=snapshot.child("email").getValue(String.class);
                                String donor=snapshot.child("donor").getValue(String.class);
                                if(donor.equals("1")){
                                    Person x = new Person(name,blood);
                                    dolist.add(x);
                                    doinfo.add(mail);
                                }
                            }
                            padapter adapter =new padapter(ViewListContents.this,R.layout.adapter_view_layout,dolist);
                            listview.setAdapter(adapter);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
        }
        progressDialog1.hide();
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                progressDialog.setMessage("Fetching donor's info...");
                progressDialog.show();
                Intent i = new Intent(ViewListContents.this,DonorInfo.class);
                i.putExtra("useri",doinfo.get(position));
                startActivity(i);
                progressDialog.hide();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(ViewListContents.this,bloodselection.class);
        startActivity(i);
    }
}
