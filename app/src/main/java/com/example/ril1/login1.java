package com.example.ril1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class login1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private String[] company = {"Company1","Company2","Company3"};
    String selectedcomp = null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        Button b1 = (Button)findViewById(R.id.b1) ;
        Spinner spin = (Spinner) findViewById(R.id.spin);

        spin.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,company);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Login2.class);
                intent.putExtra("name", selectedcomp);
                startActivity(intent);
            }
        });


    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),company[position] , Toast.LENGTH_LONG).show();
        selectedcomp = company[position] ;
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}