package com.example.ril1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DashBoard extends AppCompatActivity {
CardView bfe,pcp,manageuser,runningstatus, inspection ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        Bundle bundle = getIntent().getExtras();
        final String companyname = bundle.getString("name");

        bfe = (CardView) findViewById(R.id.bfe) ;
        bfe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmainact(companyname);
            }
        });

        pcp = (CardView) findViewById(R.id.pcp) ;
        pcp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpcp(companyname);
            }
        });

        runningstatus = (CardView) findViewById(R.id.view2) ;
        runningstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Showequiprunstat.class);
                intent1.putExtra("name", companyname);
                startActivity(intent1);
            }
        });

        inspection = (CardView) findViewById(R.id.view1) ;
        inspection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), Inspection.class);
                intent1.putExtra("name", companyname);
                startActivity(intent1);
            }
        });

        manageuser = (CardView) findViewById(R.id.usermanage) ;
        manageuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openusermanagement(companyname) ;
            }
        });




    }


    public void openmainact(String companyname){
        Intent intent1 = new Intent(this, LogHistory.class);
        intent1.putExtra("name", companyname);
        startActivity(intent1);
    }
    public void openpcp(String companyname ){
        Intent intent1 = new Intent(this, PCP.class);
        intent1.putExtra("name", companyname);
        startActivity(intent1);
    }

    public void  openusermanagement(String companyname){
        Intent intent1 = new Intent(this, ManageUser.class);
        intent1.putExtra("name", companyname);
        startActivity(intent1);
    }



}
