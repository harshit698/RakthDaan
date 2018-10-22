package com.example.dellpc.bloodbank;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends Activity {
    Button login;
    EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_admin_login);
        login=(Button)findViewById(R.id.button21);
        user=(EditText)findViewById(R.id.editText8);
        pass=(EditText)findViewById(R.id.editText9);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String log=user.getText().toString();
                String pas=pass.getText().toString();

                if(log.equals("")||pass.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter User ID/Password",Toast.LENGTH_LONG).show();
                }
                else if(log.equals("BloodDonationProject") && pas.equals("BloodDonation")){
                    Intent i = new Intent(AdminLogin.this,Admin.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(getApplicationContext(),"You are not an admin!!!",Toast.LENGTH_LONG).show();
                    user.setText("");
                    pass.setText("");
                }
            }
        });
    }
}
