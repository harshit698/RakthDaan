package com.example.dellpc.bloodbank;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DonorInfo extends AppCompatActivity {
    Button back,logout;
    TextView a,b,c,d,e;
    ImageButton call,msz,mail;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_donor_info);
        progressDialog = new ProgressDialog(DonorInfo.this);
        back=(Button)findViewById(R.id.button11);
        mail = (ImageButton)findViewById(R.id.imageButton4);
        logout=(Button)findViewById(R.id.button14);
        a=(TextView)findViewById(R.id.textView16);
        b=(TextView)findViewById(R.id.textView22);
        c=(TextView)findViewById(R.id.textView23);
        d=(TextView)findViewById(R.id.textView24);
        e=(TextView)findViewById(R.id.textView26);
        call=(ImageButton)findViewById(R.id.imageButton6);
        msz=(ImageButton)findViewById(R.id.imageButton9);
        final String useri=getIntent().getStringExtra("useri");
        progressDialog.setMessage("Fetching donor's info...");
        progressDialog.show();
        FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("email").equalTo(useri)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                            String name=snapshot.child("name").getValue(String.class);
                            String blood=snapshot.child("bloodgrp").getValue(String.class);
                            String dob=snapshot.child("dob").getValue(String.class);
                            String sex=snapshot.child("sex").getValue(String.class);
                            String phone=snapshot.child("number").getValue(String.class);
                            a.setText(name);
                            b.setText(dob);
                            c.setText(phone);
                            d.setText(sex);
                            e.setText(blood);
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
        progressDialog.hide();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DonorInfo.this,bloodselection.class);
                startActivity(i);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(DonorInfo.this,Homescreen.class);
                startActivity(i);
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent=new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+c.getText().toString()));
                startActivity(callIntent);
            }
        });
        msz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sms=new Intent(Intent.ACTION_SENDTO,Uri.parse("sms:"+c.getText().toString()));
                sms.putExtra("sms_body","Chat_data from Blood Bank:"+"\n" +"In urgent need of blood donor. Kindly contact this number to donate blood."+"\n" +"Thank You!!!");
                startActivity(sms);

            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mail = new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto",useri,null));
                mail.putExtra(Intent.EXTRA_SUBJECT,"Chat_data from blood bank");
                mail.putExtra(Intent.EXTRA_TEXT,"In urgent need of blood donor. Kindly contact to donate blood."+"\n" +"Thank You!!!");
                startActivity(mail);
            }
        });
    }
}
