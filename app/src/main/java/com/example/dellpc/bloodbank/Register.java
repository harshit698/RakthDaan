package com.example.dellpc.bloodbank;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Register extends Activity{
    DatabaseHandler db;
    ProgressDialog progressDialog;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    TextView mo;
    public EditText userid,password,name,dob,number;
    RadioButton male,female;
    public String sex="",bloodgrp="",phone="",birth="",useri="",pass="",nam="";
    Button home,reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_register);
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(Register.this);
        databaseReference = FirebaseDatabase.getInstance().getReference("Registerdata");
        Spinner myspinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Register.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.names));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(myAdapter);

        myspinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String label = adapterView.getItemAtPosition(i).toString();
                if (label.equals("Select any"))
                    bloodgrp = "";
                else
                    bloodgrp = label;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        userid = (EditText) findViewById(R.id.editText3);
        password = (EditText) findViewById(R.id.editText4);
        name = (EditText) findViewById(R.id.editText5);
        dob = (EditText) findViewById(R.id.editText6);
        number = (EditText) findViewById(R.id.editText7);
        male = (RadioButton) findViewById(R.id.Male);
        female = (RadioButton) findViewById(R.id.female);
        home = (Button) findViewById(R.id.button16);
        mo=(TextView)findViewById(R.id.textView14);
        reg=(Button)findViewById(R.id.button5);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this, Homescreen.class);
                startActivity(i);
            }
        });
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (male.isChecked())
                    sex = "Male";
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (female.isChecked())
                    sex = "Female";
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                db = new DatabaseHandler(Register.this, null, null, 1);
                phone = number.getText().toString();
                birth = dob.getText().toString();
                useri = userid.getText().toString();
                pass = password.getText().toString();
                nam = name.getText().toString();
                progressDialog.setMessage("Registering User...");
                String mail = db.getregister(useri);
                if (phone.equals("") || birth.equals("") || useri.equals("") || pass.equals("") || nam.equals("") || sex.equals("") || bloodgrp.equals("")) {

                    Toast.makeText(getApplicationContext(), "Enter All Fields", Toast.LENGTH_LONG).show();
                } else if (phone.length() != 10) {
                    mo.setText("Enter Valid Mobile Number");
                }
                else if(pass.length()<6){
                    Toast.makeText(getApplicationContext(), "Password length less than 6", Toast.LENGTH_LONG).show();
                }else {
                    if (mail.equals("BloodDonationProject")) {
                        Toast.makeText(getApplicationContext(), "Email already Exists", Toast.LENGTH_LONG).show();
                    } else {
                        progressDialog.show();
                        firebaseAuth.createUserWithEmailAndPassword(useri, pass)
                                .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(task.isSuccessful()){
                                            String id = databaseReference.push().getKey();
                                            Registerdata reg = new Registerdata();
                                            reg.setname(nam);
                                            reg.setemail(useri);
                                            reg.setbloodgrp(bloodgrp);
                                            reg.setsex(sex);
                                            reg.setdob(birth);
                                            reg.setnumber(phone);
                                            reg.setDonor("0");
                                            databaseReference.child(id).setValue(reg);
                                            Toast.makeText(getApplicationContext(),"Registered",Toast.LENGTH_LONG).show();
                                            Intent i = new Intent(Register.this, Loign.class);
                                            startActivity(i);
                                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                            user.sendEmailVerification()
                                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            if(task.isSuccessful()){
                                                                Toast.makeText(getApplicationContext(),"Verification mail sent",Toast.LENGTH_LONG).show();
                                                                finish();
                                                            }
                                                        }
                                                    });
                                            progressDialog.hide();
                                        }
                                        else{
                                            Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_LONG).show();
                                            progressDialog.hide();
                                        }
                                    }
                                });



                    }
                }

            }

                    });

                }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Register.this,Homescreen.class);
        startActivity(i);
    }
}






