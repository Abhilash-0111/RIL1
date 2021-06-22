package com.example.ril1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class signup1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
EditText email, password, name,phone ;
Button signup ;
Spinner post ;
    private String[] posts = {"Level1","Level2","Level3"};
    String selectedposts = null ;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);

        Bundle bundle = getIntent().getExtras();
        final String companyname = bundle.getString("name");

        post = (Spinner)findViewById(R.id.spin) ;
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        name = (EditText)findViewById(R.id.name);
        phone = (EditText)findViewById(R.id.phone);
        signup = (Button)findViewById(R.id.signup) ;
        post.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,posts);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        post.setAdapter(aa);

signup.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        mAuth = FirebaseAuth.getInstance();


        final String email1, password1 , post1, name1,phone1 ;

        email1 = email.getText().toString() ;
        password1 = password.getText().toString() ;
        name1 = name.getText().toString() ;
        phone1 = phone.getText().toString() ;
        mAuth.createUserWithEmailAndPassword(email1, password1)
                .addOnCompleteListener(signup1.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            String uid = user.getUid();

                            mDatabase = FirebaseDatabase.getInstance().getReference();
                            mDatabase.child("User").child(uid).child("post").setValue(selectedposts);
                            mDatabase.child("User").child(uid).child("name").setValue(name1);
                            mDatabase.child("User").child(uid).child("uid").setValue(uid);
                            mDatabase.child("User").child(uid).child("companyname").setValue(companyname);
                            mDatabase.child("User").child(uid).child("phone").setValue(phone1);


                            Toast.makeText(signup1.this, "Authentication success.", Toast.LENGTH_SHORT).show();


                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(signup1.this, "Authentication failed."+task.getException(),
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });

    }
});





    }


    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),posts[position] , Toast.LENGTH_LONG).show();
        selectedposts= posts[position] ;
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}