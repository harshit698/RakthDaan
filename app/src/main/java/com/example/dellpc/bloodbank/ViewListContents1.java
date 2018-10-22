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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.dellpc.bloodbank.R.id.listview;

public class ViewListContents1 extends Activity {
    DatabaseHandler db;
    ProgressDialog progressDialog,progressDialog1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.viewcontent1);
        final ListView listView=(ListView)findViewById(R.id.listview1);
        db=new DatabaseHandler(ViewListContents1.this,null,null,1);
        final ArrayList<String> dolist=new ArrayList<>();
        final ArrayList<String> mai=new ArrayList<>();
        progressDialog1 = new ProgressDialog(ViewListContents1.this);
        progressDialog = new ProgressDialog(ViewListContents1.this);
        progressDialog.setMessage("Retrieving all users...");
        progressDialog.show();
        FirebaseDatabase.getInstance().getReference("Registerdata")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                            String mail=snapshot.child("email").getValue(String.class);
                            dolist.add("Email: "+mail);
                            mai.add(mail);
                        }
                        ListAdapter listAdapter=new ArrayAdapter(ViewListContents1.this,android.R.layout.simple_list_item_1,dolist);
                        listView.setAdapter(listAdapter);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
        progressDialog.hide();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                progressDialog1.setMessage("Fetching user's info...");
                progressDialog1.show();
                Intent i = new Intent(ViewListContents1.this,AdminDonorInfo.class);
                i.putExtra("userii",mai.get(position).toString());
                startActivity(i);
                progressDialog1.hide();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(ViewListContents1.this,Admin.class);
        startActivity(i);
    }
}
