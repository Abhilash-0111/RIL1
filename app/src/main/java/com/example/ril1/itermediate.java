package com.example.ril1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class itermediate extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        final String companyname = bundle.getString("name");
        setContentView(R.layout.activity_itermediate);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String uid = user.getUid();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("User");


        myRef.child(uid).child("post").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               String post = dataSnapshot.getValue(String.class);

               if(post.equals("Level3")){
                   Intent intent = new Intent(getApplicationContext(), oDashboard.class);
                   intent.putExtra("name", companyname);
                   startActivity(intent);
                   finish();
               }
               else{
                   Intent intent = new Intent(getApplicationContext(), DashBoard.class);
                   intent.putExtra("name", companyname);
                   startActivity(intent);
                   finish();
               }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Something went wrong",Toast.LENGTH_SHORT ).show();
            }

        }) ;



    }
}