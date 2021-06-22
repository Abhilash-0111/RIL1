package com.example.ril1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StartActivity extends AppCompatActivity {
EditText userid , password ;
Button login ;

    String useriddb ;
    String passworddb ;
    String passwordi ;
    String useridi ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("ol");

        myRef.child("userid").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                useriddb = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Can not login",Toast.LENGTH_SHORT ).show();
            }

        }) ;
        myRef.child("password").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                passworddb = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Can not login",Toast.LENGTH_SHORT ).show();
            }

        }) ;






        userid  = (EditText)findViewById(R.id.userid) ;
        password = (EditText)findViewById(R.id.password);
        login = (Button)findViewById(R.id.signup) ;



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useridi = userid.getText().toString() ;
                passwordi = password.getText().toString() ;


                myRef.child("password").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        passworddb = dataSnapshot.getValue(String.class);

                        if( passwordi.equalsIgnoreCase(passworddb)){
                            signup();
                        }
                        else{

                            Toast.makeText(StartActivity.this,"Enter correct login credential ",Toast.LENGTH_LONG).show();


                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "Can not login",Toast.LENGTH_SHORT ).show();
                    }

                }) ;





            }
        }) ;




    }




///




    public void signup(){



          Intent intent = new Intent(StartActivity.this, oDashboard.class);
          startActivity(intent);





    }


}
