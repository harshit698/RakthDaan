package com.example.dellpc.bloodbank;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminDonorInfo extends Activity {
    TextView a,b,c,d,e,f;
    Button dele;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_admin_donor_info);
       final String userii=getIntent().getStringExtra("userii");
        progressDialog = new ProgressDialog(AdminDonorInfo.this);
        a=(TextView)findViewById(R.id.textView32);
        b=(TextView)findViewById(R.id.textView33);
        c=(TextView)findViewById(R.id.textView34);
        d=(TextView)findViewById(R.id.textView35);
        e=(TextView)findViewById(R.id.textView36);
        f=(TextView)findViewById(R.id.textView37);
        dele=(Button)findViewById(R.id.button22);
        progressDialog.setMessage("Fetching donor's info...");
        progressDialog.show();
        Toast.makeText(getApplicationContext(),userii,Toast.LENGTH_LONG).show();
        FirebaseDatabase.getInstance().getReference("Registerdata").orderByChild("email").equalTo(userii)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                            String name=snapshot.child("name").getValue(String.class);
                            String blood=snapshot.child("bloodgrp").getValue(String.class);
                            String dob=snapshot.child("dob").getValue(String.class);
                            String sex=snapshot.child("sex").getValue(String.class);
                            String phone=snapshot.child("number").getValue(String.class);
                            String donor=snapshot.child("donor").getValue(String.class);
                            a.setText(name);
                            b.setText(dob);
                            c.setText(phone);
                            d.setText(sex);
                            e.setText(blood);
                            f.setText(donor);
                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
        progressDialog.hide();
        dele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a_builder=new AlertDialog.Builder(AdminDonorInfo.this);
                a_builder.setMessage("Back...")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent i = new Intent(AdminDonorInfo.this,Admin.class);
                                startActivity(i);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert=a_builder.create();
                alert.setTitle("Alert!!!");
                alert.show();
            }
        });
    }

}
