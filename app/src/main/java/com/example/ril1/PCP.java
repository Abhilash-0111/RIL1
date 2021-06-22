package com.example.ril1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class PCP extends AppCompatActivity {
    Button load ;
    PCPclass pcplist ;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,updatetime ;
    Date time ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_c_p);
        FirebaseDatabase database = FirebaseDatabase.getInstance();



        Bundle bundle = getIntent().getExtras();
        final String companyname = bundle.getString("name");


        final DatabaseReference myRef = database.getReference(companyname).child("pcp");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pcplist = dataSnapshot.getValue(PCPclass.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Something went wrong",Toast.LENGTH_SHORT ).show();
            }

        }) ;
        final DatabaseReference myRef1 = database.getReference(companyname).child("pcptime");

        myRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                time = dataSnapshot.getValue(Date.class);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Something went wrong",Toast.LENGTH_SHORT ).show();
            }

        }) ;



        t1=findViewById(R.id.t1) ;
        t2=findViewById(R.id.t2) ;
        t3=findViewById(R.id.t3) ;
        t4=findViewById(R.id.t4) ;
        t5=findViewById(R.id.t5) ;
        t6=findViewById(R.id.t6) ;
        t7=findViewById(R.id.t7) ;
        t8=findViewById(R.id.t8) ;
        t9=findViewById(R.id.t9) ;
        t10=findViewById(R.id.t10) ;
        t11=findViewById(R.id.t11) ;
        t12=findViewById(R.id.t12) ;
        t13=findViewById(R.id.t13) ;
        t14=findViewById(R.id.t14) ;
        t15=findViewById(R.id.t15) ;
        t16=findViewById(R.id.t16) ;
        t17=findViewById(R.id.t17) ;
        t18=findViewById(R.id.t18) ;
        t19=findViewById(R.id.t19) ;
        t20=findViewById(R.id.t20) ;
        updatetime=findViewById(R.id.updattime) ;
        load = findViewById(R.id.load) ;

load.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        updatetime.setText("Updated on : "+time);
        t1.setText("Boiler Steamflow =  "+pcplist.p1+" TPH");
        t2.setText("Boiler Feed Waterflow  =  "+pcplist.p2+" TPH");
        t3.setText("Turbine Load  =  "+pcplist.p3+" MW  ");
        t4.setText("Turbin exhout presuure  =  "+pcplist.p4+" ata/mm of HG ");
        t5.setText("Coal flow    =   "+pcplist.p5+" TPH  ");
        t6.setText("D/A level =   "+pcplist.p6+"%  ");
        t7.setText("Hot Well Level  =  "+pcplist.p7+"%  ");
        t8.setText("Drum Level =   "+pcplist.p8+"%  ");
        t9.setText("Steam Pressure of Boiler Outlet =  "+pcplist.p9+" KG/CM^2  ");
        t10.setText("Steam Temperature at Boiler Outlet  =  "+pcplist.p10+"  C ");
        t11.setText("Fixed Water Inlet Temperature  =  "+pcplist.p11+"  C  ");
        t12.setText("PA air flow  =  "+pcplist.p12+" TPH  ");
        t13.setText("SA air flow  =  "+pcplist.p13+" TPH  ");
        t14.setText("ID Fan Motor Loading  =  "+pcplist.p14+" amps  ");
        t15.setText("Wind Box Pressure  =  "+pcplist.p15+" mWC  ");
        t16.setText("Furnace Temperature  =  "+pcplist.p16+"  C  ");
        t17.setText("Furnace draft =   "+pcplist.p17+" mnC  ");
        t18.setText("Steam Drum Pressure  =  "+pcplist.p18+" KG/CM^2  ");
        t19.setText("Flow Gas Exit Temperature   =  "+ pcplist.p19+" C  ");
        t20.setText("Bed Temperature  =  "+pcplist.p20+" C  ");

    }
});



    }
}
