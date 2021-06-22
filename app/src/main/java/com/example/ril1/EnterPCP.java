package com.example.ril1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class EnterPCP extends AppCompatActivity {

    EditText e1, e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,e17,e18,e19,e20 ;
    Button submit ;
    private DatabaseReference mDatabase;
    PCPclass obj2 ;
    Date currenttime ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_p_c_p);

        Bundle bundle = getIntent().getExtras();
        final String companyname = bundle.getString("name");


        currenttime = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss") ;
        String time = dateFormat.format(currenttime) ;



        e1=(EditText)findViewById(R.id.e1) ;
        e2=(EditText)findViewById(R.id.e2) ;
        e3=(EditText)findViewById(R.id.e3) ;
        e4=(EditText)findViewById(R.id.e4) ;
        e5=(EditText)findViewById(R.id.e5) ;
        e6=(EditText)findViewById(R.id.e6) ;
        e7=(EditText)findViewById(R.id.e7) ;
        e8=(EditText)findViewById(R.id.e8) ;
        e9=(EditText)findViewById(R.id.e9) ;
        e10=(EditText)findViewById(R.id.e10) ;
        e11=(EditText)findViewById(R.id.e11) ;
        e12=(EditText)findViewById(R.id.e12) ;
        e13=(EditText)findViewById(R.id.e13) ;
        e14=(EditText)findViewById(R.id.e14) ;
        e15=(EditText)findViewById(R.id.e15) ;
        e16=(EditText)findViewById(R.id.e16) ;
        e17=(EditText)findViewById(R.id.e17) ;
        e18=(EditText)findViewById(R.id.e18) ;
        e19=(EditText)findViewById(R.id.e19) ;
        e20=(EditText)findViewById(R.id.e20) ;


        submit = findViewById(R.id.submit) ;
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss") ;
                String time = dateFormat.format(currenttime) ;

                PCPclass obj1 = new PCPclass() ;
                obj1.p1 = Double.valueOf(e1.getText().toString());
                obj1.p2 = Double.valueOf(e2.getText().toString());
                obj1.p3 = Double.valueOf(e3.getText().toString());
                obj1.p4 = Double.valueOf(e4.getText().toString());
                obj1.p5 = Double.valueOf(e5.getText().toString());
                obj1.p6 = Double.valueOf(e6.getText().toString());
                obj1.p7 = Double.valueOf(e7.getText().toString());
                obj1.p8 = Double.valueOf(e8.getText().toString());
                obj1.p9 = Double.valueOf(e9.getText().toString());
                obj1.p10 = Double.valueOf(e10.getText().toString());
                obj1.p11 = Double.valueOf(e11.getText().toString());
                obj1.p12 = Double.valueOf(e12.getText().toString());
                obj1.p13 = Double.valueOf(e13.getText().toString());
                obj1.p14 = Double.valueOf(e14.getText().toString());
                obj1.p15 = Double.valueOf(e15.getText().toString());
                obj1.p16 = Double.valueOf(e16.getText().toString());
                obj1.p17 = Double.valueOf(e17.getText().toString());
                obj1.p18 = Double.valueOf(e18.getText().toString());
                obj1.p19 = Double.valueOf(e19.getText().toString());
                obj1.p20 = Double.valueOf(e20.getText().toString());
                obj1.time = currenttime ;

                mDatabase = FirebaseDatabase.getInstance().getReference();
                mDatabase.child(companyname).child("pcp").setValue(obj1);
                mDatabase.child(companyname).child("pcptime").setValue(currenttime);
                Toast.makeText(EnterPCP.this,time+"Record submitted succesfully "+currenttime,Toast.LENGTH_LONG).show();



            }
        });



    }
}
