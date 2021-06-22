package com.example.ril1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class oDashboard extends AppCompatActivity {

    CardView bfe,pcp,inspection,runningstatus ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_dashboard);
        Bundle bundle = getIntent().getExtras();
        final String companyname = bundle.getString("name");

        bfe = (CardView) findViewById(R.id.bfe) ;
        bfe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmainact(companyname);
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

        pcp = (CardView) findViewById(R.id.pcp) ;
        pcp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openpcp(companyname);
            }
        });

runningstatus = (CardView)findViewById(R.id.view2) ;
runningstatus.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent1 = new Intent(getApplicationContext(), EquipRunStat.class);
        intent1.putExtra("name", companyname);
        startActivity(intent1);

    }
});



    }


    public void openmainact(String companyname){
        Intent intent1 = new Intent(this, MainActivity.class);
        intent1.putExtra("name",companyname) ;
        startActivity(intent1);
    }
    public void openpcp(String companyname){
        Intent intent1 = new Intent(this, EnterPCP.class);
        intent1.putExtra("name",companyname) ;
        startActivity(intent1);
    }


}
