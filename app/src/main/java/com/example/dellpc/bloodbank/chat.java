package com.example.dellpc.bloodbank;

import android.os.*;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

import static android.R.attr.id;
import static com.example.dellpc.bloodbank.R.drawable.email;

public class chat extends AppCompatActivity {
    private EditText editText;
    private DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    Button b;
    private ListView listView;
    private FirebaseAuth mAuth;
    private String name="";
    HashMap<String,String> map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        editText=(EditText)findViewById(R.id.edittext111);
        listView=(ListView)findViewById(R.id.listview111);
        b=(Button)findViewById(R.id.senddd);
        final ArrayList<String> cchat=new ArrayList<>();
        FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
        final String mail = user.getEmail();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msz = editText.getText().toString();
                if(!msz.equals("")) {
                    databaseReference = FirebaseDatabase.getInstance().getReference("Chat_data");
                    String id = databaseReference.push().getKey();
                    Chat_data cc = new Chat_data();
                    cc.setMessage(msz);
                    cc.setUser_name(mail);
                    databaseReference.child(id).setValue(cc);
                    editText.setText("");
                }
            }
        });

        FirebaseDatabase.getInstance().getReference("Chat_data")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        cchat.clear();
                        for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                            String mail=snapshot.child("user_name").getValue(String.class);
                            String ussr=snapshot.child("message").getValue(String.class);
                            cchat.add(mail+":\n"+ussr);
                        }
                        ListAdapter listAdapter=new ArrayAdapter(chat.this,android.R.layout.simple_list_item_1,cchat);

                        listView.setAdapter(listAdapter);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }
}

