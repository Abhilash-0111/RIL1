package com.example.ril1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Showequiprunstat extends AppCompatActivity {
    ImageView i1,i2,i3,i4 ;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showequiprunstat);



        i1 = (ImageView)findViewById(R.id.id1) ;
        i2 = (ImageView)findViewById(R.id.id2) ;
        i3 = (ImageView)findViewById(R.id.id3) ;
        i4 = (ImageView)findViewById(R.id.id4) ;


        mDatabase = FirebaseDatabase.getInstance().getReference();


        Bundle bundle = getIntent().getExtras();
        final String companyname = bundle.getString("name");


        mDatabase.child(companyname).child("color").child("1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s1 = dataSnapshot.getValue(String.class);
                if(s1.equals("red")){
                    i1.setBackgroundColor(Color.parseColor("#DD2C00"));


                }
                else {
                    if (s1.equals("green")) {
                        i1.setBackgroundColor(Color.parseColor("#64DD17"));

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Something went wrong",Toast.LENGTH_SHORT ).show();
            }

        }) ;

        mDatabase.child(companyname).child("color").child("2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s1 = dataSnapshot.getValue(String.class);
                if(s1.equals("red")){
                    i2.setBackgroundColor(Color.parseColor("#DD2C00"));


                }
                else {
                    if (s1.equals("green")) {
                        i2.setBackgroundColor(Color.parseColor("#64DD17"));

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Something went wrong",Toast.LENGTH_SHORT ).show();
            }

        }) ;
        mDatabase.child(companyname).child("color").child("3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s1 = dataSnapshot.getValue(String.class);
                if(s1.equals("red")){
                    i3.setBackgroundColor(Color.parseColor("#DD2C00"));


                }
                else {
                    if (s1.equals("green")) {
                        i3.setBackgroundColor(Color.parseColor("#64DD17"));

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Something went wrong",Toast.LENGTH_SHORT ).show();
            }

        }) ;
        mDatabase.child(companyname).child("color").child("4").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String s1 = dataSnapshot.getValue(String.class);
                if(s1.equals("red")){
                    i4.setBackgroundColor(Color.parseColor("#DD2C00"));


                }
                else {
                    if (s1.equals("green")) {
                        i4.setBackgroundColor(Color.parseColor("#64DD17"));

                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Something went wrong",Toast.LENGTH_SHORT ).show();
            }

        }) ;






    }
}