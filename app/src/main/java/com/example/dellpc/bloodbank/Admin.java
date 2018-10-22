package com.example.dellpc.bloodbank;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Admin extends Activity {
    Button logout,showall;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_homescreen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_admin);
        progressDialog = new ProgressDialog(Admin.this);
        logout=(Button)findViewById(R.id.button20);
        showall=(Button)findViewById(R.id.button18);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Admin.this,Homescreen.class);
                startActivity(i);
            }
        });
        showall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Retrieving all users...");
                progressDialog.show();
                Intent i = new Intent(Admin.this,ViewListContents1.class);
                startActivity(i);
                progressDialog.hide();
            }
        });
    }

    @Override
    public void onBackPressed() {
    }
}
