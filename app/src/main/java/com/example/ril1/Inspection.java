package com.example.ril1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Inspection extends AppCompatActivity {
String name , detail , inventory , picurl , vurl ;
EditText namee , detaile , inventorye , picurle , vurle ;
    Button submit ;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspection);
        namee = (EditText) findViewById(R.id.e1) ;
        detaile = (EditText) findViewById(R.id.e2) ;
        inventorye = (EditText) findViewById(R.id.e3) ;
        picurle = (EditText) findViewById(R.id.e4) ;
        vurle = (EditText) findViewById(R.id.e5) ;
        submit = (Button) findViewById(R.id.submit);
        mAuth = FirebaseAuth.getInstance();

        Bundle bundle = getIntent().getExtras();
        final String companyname = bundle.getString("name");
        FirebaseUser user = mAuth.getCurrentUser();
        // final String name = user.getDisplayName();
        final String usermail = user.getEmail();


        String uid = user.getUid();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("User");


        myRef.child(uid).child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                name = dataSnapshot.getValue(String.class);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Something went wrong",Toast.LENGTH_SHORT ).show();
            }

        }) ;



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = namee.getText().toString();
                detail = detaile.getText().toString() ;
                inventory = inventorye.getText().toString() ;
                picurl = picurle.getText().toString() ;
                vurl = vurle.getText().toString() ;
InsClass i1 = new InsClass(name,detail,inventory,picurl,vurl) ;
                mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.child(companyname).child("inspection").push().setValue(i1) ;
              //  mDatabase.child(companyname).child("inspection").child(String.valueOf(count)).child("time").setValue(currenttime);



            }
        });


    }
}