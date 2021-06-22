package com.example.ril1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login2 extends AppCompatActivity {

EditText email, password ;
Button login, signup ;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        Bundle bundle = getIntent().getExtras();
        final String companyname = bundle.getString("name");

        email = (EditText)findViewById(R.id.email) ;
        password = (EditText)findViewById(R.id.password) ;
        login = (Button)findViewById(R.id.login) ;
        signup = (Button)findViewById(R.id.signup) ;

        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            Intent intent = new Intent(getApplicationContext(), itermediate.class);
            intent.putExtra("name", companyname);
            startActivity(intent);
            finish();
        }
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), signup1.class);
                intent.putExtra("name", companyname);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1 = email.getText().toString();
                final String password1 = password.getText().toString();

                if (TextUtils.isEmpty(email1)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password1)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }



                //authenticate user
                auth.signInWithEmailAndPassword(email1, password1)

                        .addOnCompleteListener(Login2.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.

                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 6) {
                                        password.setError(getString(R.string.passer)) ;
                                    } else {
                                        Toast.makeText(Login2.this, getString(R.string.passer), Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    Intent intent = new Intent(getApplicationContext(), itermediate.class);
                                    intent.putExtra("name", companyname);
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        });


            }
        });

    }
}