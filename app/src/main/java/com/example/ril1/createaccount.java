package com.example.ril1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class createaccount extends AppCompatActivity {
EditText fname,lname,email,password,mobile ;
String fnames , emails, passwords,lnames,mobiles ;
Button signup ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);

        fname = (EditText)findViewById(R.id.fname) ;
        lname = (EditText)findViewById(R.id.lname) ;
        email = (EditText)findViewById(R.id.email) ;
        password = (EditText)findViewById(R.id.password) ;
        signup = (Button)findViewById(R.id.signup) ;



        signup.setOnClickListener(new View.OnClickListener() {
            private FirebaseAuth mAuth;

            @Override
            public void onClick(View v) {

                fnames = fname.getText().toString() ;
                lnames = lname.getText().toString() ;
                emails = email.getText().toString() ;
                passwords = password.getText().toString() ;

                if (TextUtils.isEmpty(emails)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(passwords)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth = FirebaseAuth.getInstance();


                mAuth.createUserWithEmailAndPassword(emails, passwords)
                        .addOnCompleteListener(createaccount.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(createaccount.this, "Authentication success.",
                                            Toast.LENGTH_SHORT).show();
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    String uid = user.getUid();





                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(createaccount.this, "Authentication failed."+task.getException(),
                                            Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }
                        });

            }
        });



    }
}