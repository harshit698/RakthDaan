package com.example.dellpc.bloodbank;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class Loign extends Activity {
    Button login,register;
    EditText lo,pa;
    DatabaseHandler db;
    ProgressDialog progressDialog;
    TextView reset;
    Cursor cursor;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    final Context context=Loign.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_loign);
        progressDialog = new ProgressDialog(Loign.this);
        firebaseAuth=FirebaseAuth.getInstance();
        lo=(EditText)findViewById(R.id.editText);
        reset=(TextView)findViewById(R.id.forget);
        pa=(EditText)findViewById(R.id.editText2);
        login=(Button)findViewById(R.id.button3);
        register=(Button)findViewById(R.id.button4);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater=LayoutInflater.from(context);
                View promptView=layoutInflater.inflate(R.layout.prompt,null);
                AlertDialog.Builder alertDialogue=new AlertDialog.Builder(context);
                alertDialogue.setView(promptView);
                final EditText input = (EditText)promptView.findViewById(R.id.maill);
                alertDialogue.setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String mail = input.getText().toString();
                        if(!mail.equals("")) {
                            FirebaseAuth auth = FirebaseAuth.getInstance();
                            auth.sendPasswordResetEmail(mail)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(getApplicationContext(), "Reset link sent!!!", Toast.LENGTH_LONG).show();
                                            } else {
                                                Toast.makeText(getApplicationContext(), "Invalid email", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Field blank", Toast.LENGTH_LONG).show();
                        }
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
            alertDialogue.create();
                alertDialogue.show();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View args0) {
                String pas=pa.getText().toString();
                String log=lo.getText().toString();
                if(pas.equals("") || log.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter all fields",Toast.LENGTH_LONG).show();
                }
                else {
                    progressDialog.setMessage("Logging in...");
                    progressDialog.show();
                    firebaseAuth.signInWithEmailAndPassword(log, pas)
                            .addOnCompleteListener(Loign.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        if(!FirebaseAuth.getInstance().getCurrentUser().isEmailVerified()){
                                            Toast.makeText(getApplicationContext(),"Email not verified",Toast.LENGTH_LONG).show();
                                            pa.setText("");
                                            lo.setText("");
                                            progressDialog.hide();
                                        }
                                        else {
                                            Intent intent = new Intent(Loign.this, Acceptdonate.class);
                                            startActivity(intent);
                                            progressDialog.hide();
                                        }
                                    }
                                    else {
                                        Toast.makeText(getApplicationContext(), "Incorrect Email/Password", Toast.LENGTH_LONG).show();
                                        pa.setText("");
                                        lo.setText("");
                                        progressDialog.hide();
                                    }

                                }
                            });

                }

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Loign.this,Register.class);
                startActivity(i);
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_settings:
                // search action
                Intent i=new Intent(Loign.this,Register.class);
                startActivity(i);
                return true;
        }
        return false;

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Loign.this,Homescreen.class);
        startActivity(i);
    }
}
