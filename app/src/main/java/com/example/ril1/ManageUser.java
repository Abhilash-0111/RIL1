package com.example.ril1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ManageUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_user);

        Bundle bundle = getIntent().getExtras();
        final String companyname = bundle.getString("name");



    }
}