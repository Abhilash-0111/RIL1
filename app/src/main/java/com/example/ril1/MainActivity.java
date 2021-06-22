package com.example.ril1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.nio.charset.StandardCharsets.UTF_8;

public class MainActivity extends AppCompatActivity {
 EditText bottumash,flyash, co2,co,c,T,t,M,A,gcv,vm,losifa,losiba,eo2  ;
    FirebaseAuth mAuth;
    int count = 0 ;
    String phone ;
 TextView v1,v2,v3,v4,v5,v6 ,v7,v8,tl,be ;
    double ncv ;
 Button b1 ,submit,history,help ;
    double boilereffic ;
 double bottumash1,flyash1, co21,co1,c1,s1,T1,t1,M1,H1,A1,N21,h1=0.4,dafc,vmc,h2c,fcc,cc,nc,eo21,Cua,Oua,vm1,losibfa1,losiba1, DFGL,DFGLP,WFGL, WFGLP,SHWVL,SHWVLP,MCA,MCAP, UGL,UGLP, CA,CAP,RL = 0.92,RLP=0.9  ;
  double gcv1,TAR,EA, AAS,L8,L7,L5 = 0.5 , L6 = 1  ;
 double carbon_ba , carbon_fa, W_carbon_con, ma ;
    private DatabaseReference mDatabase;
    double totalloss ;
    Date currenttime ;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new abcd().execute("9752218855", String.valueOf(1)) ;


        currenttime = Calendar.getInstance().getTime();
     //   DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss") ;
     //   String time = dateFormat.format(currenttime) ;
        mAuth = FirebaseAuth.getInstance();

        Bundle bundle = getIntent().getExtras();
        final String companyname = bundle.getString("name");
        FirebaseUser user = mAuth.getCurrentUser();
       // final String name = user.getDisplayName();
        final String usermail = user.getEmail();

        bottumash = (EditText) findViewById(R.id.bottumash);
        flyash = (EditText)findViewById(R.id.flyash);
     //   co2 =  (EditText) findViewById(R.id.co2);
        c = (EditText)findViewById(R.id.c);
      //  co =    (EditText)findViewById(R.id.co);
        T =  (EditText) findViewById(R.id.Tmax);
        t =   (EditText)findViewById(R.id.tmin);
        M =   (EditText)findViewById(R.id.M);
        A =   (EditText)findViewById(R.id.A);
        gcv =   (EditText)findViewById(R.id.gcv);
        vm =   (EditText)findViewById(R.id.VM);
        losiba =   (EditText)findViewById(R.id.losiba);
        losifa =   (EditText)findViewById(R.id.losifa);
        eo2 =   (EditText)findViewById(R.id.eo2);

        v1 =   (TextView) findViewById(R.id.dfgl);
        v2 =   (TextView) findViewById(R.id.wfgl);
        v3 =   (TextView) findViewById(R.id.shwpl);
        v4 =   (TextView) findViewById(R.id.mca);
        v5 =   (TextView) findViewById(R.id.ugl);
        v6 =   (TextView) findViewById(R.id.ca);
        v7 =   (TextView) findViewById(R.id.L7);
        v8 =   (TextView) findViewById(R.id.L8);
        tl =   (TextView) findViewById(R.id.tl);
        be =   (TextView) findViewById(R.id.be);
        b1 = (Button)findViewById(R.id.b1) ;
        submit = (Button)findViewById(R.id.submit) ;
        submit = (Button)findViewById(R.id.submit) ;
        history = (Button)findViewById(R.id.history) ;
        help = (Button)findViewById(R.id.help) ;





        String uid = user.getUid();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("User");


        myRef.child(uid).child("phone").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 phone = dataSnapshot.getValue(String.class);

                try {
                    new abcd().execute(phone.substring(3), String.valueOf(1));
                }catch (Exception e){}



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Something went wrong",Toast.LENGTH_SHORT ).show();
            }

        }) ;

        myRef.child(uid).child("name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                name = dataSnapshot.getValue(String.class);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), "Something went wrong",Toast.LENGTH_SHORT ).show();
            }

        }) ;



        // final String phone = mAuth.getCurrentUser().getPhoneNumber();
    try {
    new abcd().execute(phone.substring(3), String.valueOf(1));
}catch (Exception e){}


        ////
try {

    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
try {


    bottumash1 = Double.valueOf(bottumash.getText().toString());
    flyash1 = Double.valueOf(flyash.getText().toString());
    co1 = 0.02 ;//Double.valueOf(co.getText().toString());
    co21 = 15 ; // Double.valueOf(co2.getText().toString());
    M1 = Double.valueOf(M.getText().toString());
    T1 = Double.valueOf(T.getText().toString());
    t1 = Double.valueOf(t.getText().toString());
    c1 = Double.valueOf(c.getText().toString());
    A1 = Double.valueOf(A.getText().toString());
    vm1 = Double.valueOf(vm.getText().toString());
    gcv1 = Double.valueOf(gcv.getText().toString());
    losiba1 = Double.valueOf(losiba.getText().toString());
    losibfa1 = Double.valueOf(losifa.getText().toString());
    eo21 = Double.valueOf(eo2.getText().toString());
   findua() ;
    findtas();
    findea();
    findaas();


            finddfgl();
            findwfgl();
            findshwvl();
            findmca();
            ldufa();
            lduba();
            findugl();
            findca();
            totalloss = DFGLP + WFGLP + SHWVLP + MCAP + L5 + L6 + L7+L8;
            boilereffic = 100 - totalloss;
            v1.setText("Heat loss in dry flue gas   " + (DFGL*100/gcv1));
            v2.setText("Heat loss due to formation of water from  H2   " + WFGLP);
            v3.setText("Heat loss due to moisture in fuel  " + SHWVLP  );
            v4.setText("Heat loss due to moisture in air   " + MCAP  );
            v5.setText("Heat loss due to partial conversion of C to CO   " + L5);
            v6.setText("Heat loss due to radiation and convection   " + L6);
            v7.setText("Heat loss due to unburnt in fly ash " + L7);
            v8.setText("Heat loss due to unburnt in bottum ash  " + L8);
            tl.setText("Total loss is   " + totalloss);
            be.setText("Boiler efficiency is   " + boilereffic);

}
catch (NumberFormatException e){
    Toast.makeText(getApplicationContext(),"some parameter is not entered ",Toast.LENGTH_LONG).show();

}



        }
    });

}
catch (NumberFormatException e){

    Toast.makeText(this,"something went wrong ",Toast.LENGTH_LONG).show();

}


        submit.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {


                                          DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss") ;
                                          String time = dateFormat.format(currenttime) ;
                                              LogRecord l1 = new LogRecord(DFGLP, WFGLP, SHWVLP, MCAP, UGLP, CAP, RLP, boilereffic, totalloss,name,usermail,currenttime);

                                          /*    FirebaseUser user = mAuth.getCurrentUser();
                                              String uid = user.getUid();
                                              mobilenumber = user.getPhoneNumber();*/

                                              mDatabase = FirebaseDatabase.getInstance().getReference();
                                              mDatabase.child(companyname).child("logrecord").child(String.valueOf(count)).setValue(l1);
                                              mDatabase.child(companyname).child("logrecord").child(String.valueOf(count)).child("time").setValue(currenttime);

                                              count++;
                                          Toast.makeText(MainActivity.this,"Record submitted succesfully "+currenttime,Toast.LENGTH_LONG).show();


                                              try {
                                             //   new abcd().execute(phone.substring(3), String.valueOf(boilereffic)) ;

                                              } catch (Exception e) {
                                                  e.printStackTrace();
                                              }

                                                                               }
                                  });


          history.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      Intent intent1 = new Intent(MainActivity.this, LogHistory.class);
                                      intent1.putExtra("name", companyname);
                                      startActivity(intent1);
                                  }
                              });


        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Contact us at : abhlshtrpth13@gmail.com ",Toast.LENGTH_LONG).show();

            }
        });
//////





    }


    void finddfgl(){
        carbon_ba = A1*(bottumash1/100)*losiba1 ;
        carbon_fa = A1*(flyash1/100)*losibfa1 ;

        W_carbon_con = (c1/100) + (s1/267) - carbon_ba - carbon_fa ;

      //  findaas();
     //   findea();
    //    findtas();
     //   double m =   (c1/100)*44/12 + N21/100 + (AAS *77)/100 +(AAS - TAR)*23/100 +(s1/100)*64/32 ;
        double m = AAS +1 ;
        DFGL = (m*0.24)*(T1-t1) ;
       // DFGL = ((100/(12*co21 + co1))*W_carbon_con) * 30 * (T1 -t1);
        DFGLP = (DFGL*100)/gcv1 ;
    }
    // DFGL,DFGLP,WFGL, WFGLP,SHWVL,SHWVLP,MCA,MCAP, UGL,UGLP, CA,CAP,RL,RLP  ;
    void findwfgl(){

      //  WFGL = ((M1+9*H1)/100)*(1.88*(T1-25) + 2197.5 + 4.2*(25-t1)) ;
        WFGL= (9*H1*(584+0.45*(T1-t1)))/100 ;
        WFGLP = WFGL * 100 / gcv1;
    }
    void findshwvl(){

        ncv = gcv1 - (212.1*H1 - 24.4*(M1 - 0.1*A1 ) - 6 ) ;
        SHWVL = (M1/100)*(584+0.45*(T1-t1)) ;

    //  SHWVL =   WFGL - (gcv1 - ncv) ;
      SHWVLP = SHWVL*100/16716 ;

    }

    void findmca(){
h1 = 0.4  ;
        ma = (3.034*N21/co21) + co1*(c1/100 + s1/267 -carbon_fa- carbon_ba) ;
      // ma = 4.7943 ;
       // MCA = ma*h1*1.88*(T1-t1);
        MCA = AAS*0.01977*0.45*(T1-t1) ;
        MCAP = MCA*100/gcv1 ;
    }

    void ldufa(){

         L7 = (losibfa1*A1/10000)*(losibfa1*0.8*gcv1)*100/gcv1 ;


    }
    void lduba(){

         L8 = (losiba1*A1/10000)*(losiba1*0.2*gcv1)*100/gcv1 ;
    }



    void findugl(){
UGL = 0 ;
        // UGL = (co1/co21)+co1*(W_carbon_con)*23717 ;
        UGLP = UGL*100/16716 ;

    }

    void findca(){

       CA  =  carbon_ba*33820 + carbon_fa*33820 ;
       CAP = CA*100/16716 ;
    }

    void findua(){
        dafc = 100/(100-A1-M1) ;
        vmc = vm1*dafc ;
        fcc = c1*dafc ;
        h2c = vmc*(7.35/(vmc+10)-0.013) ;
        cc = 0.9*(vmc-14) ;
        nc = 2.1-(0.012*vmc) ;

            s1 = 0.4 ;
            Cua = (c1+A1)/(dafc-s1) ;
            H1 = h2c/dafc ;
            Oua =100-(Cua+H1)-(N21+s1+A1+M1) ;
            N21 = dafc/nc ;
            s1 = 0.4 ;
          //  gcv1  =((14540*Cua)+(62020*(h1-(Oua/8)))+(4050*s1));

    }


    static String sendsms(String phone , String boilereffic) throws UnsupportedEncodingException {
        try
        {
        //Your Login Credentials
       /* String username = "siksha";
        String password = "Server@123";

//Single or Multiple mobiles numbers separated by comma
        String to = "91"+phone;

//method
        String smsmethod = "groupMsg";

//Message type
        String msgtype = "text";

//Your approved sender name
        String sendername = "SGCSMS";

//Your message to send, Add URL encoding here.
        String textmessage = "Thankyou for using our app if you want to use more exciting features than use our paid version. for any help olease contact us at abhlshtrpth13@gmail.com  "+boilereffic;


        URLConnection myURLConnection=null;
        URL myURL=null;
        BufferedReader reader=null;

//encode the message content
        String encoded_message= URLEncoder.encode(textmessage,(UTF_8.toString()));

//Send SMS API
        String apiUrl="https://www.smsgateway.center/SMSApi/rest/send?";

        StringBuilder sgcPostContent= new StringBuilder(apiUrl);
        sgcPostContent.append("userId="+username);
        sgcPostContent.append("password="+password);
        sgcPostContent.append("sendMethod="+smsmethod);
        sgcPostContent.append("msgType="+msgtype);
        sgcPostContent.append("senderId="+sendername);
        sgcPostContent.append("&mobile="+to);
        sgcPostContent.append("&msg="+encoded_message);

        apiUrl = sgcPostContent.toString();

            //prepare connection
            myURL = new URL(apiUrl);
            myURLConnection =(URLConnection) myURL.openConnection();
            myURLConnection.connect();
            reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream()));

            //read the output
            String output;
            while ((output = reader.readLine()) != null)
                //print output
                Log.d("OUTPUT", ""+output);

            //Close connection
            reader.close();*/

       /////////////


            String apiKey = "apikey=" + "ZOUGzTMIcjQ-bLsDCvWAtipswBT5ALB7Y2QBu6Q4en";
            String message = "&message=" + "Thankyou for using our Remote Plant Monitoring app if you want to use more exciting features than use our paid version. for any help please contact us at abhlshtrpth13@gmail.com or akelaboiler@gmail.com";
            String sender = "&sender=" + "TXTLCL";
            String numbers = "&numbers=" + "91"+phone;

            // Send data
            HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes("UTF-8"));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = rd.readLine()) != null) {
                stringBuffer.append(line);
            }
            rd.close();

            return stringBuffer.toString();






            ///////////



        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

return "abcd" ;

    }



    void findtas() {

        TAR = ((11.6*c1) + (34.8*(H1-Oua/8)) +(4.35*s1))/100 ;
    }

    void findea() {

        EA = (eo21/(21-eo21))*100 ;
    }

    void findaas() {

        AAS = (1+EA/100)*TAR ;
    }



}



@SuppressLint("NewApi")
class abcd extends AsyncTask<String,String,Integer> {


    @Override
    protected Integer doInBackground(String... params) {
        try {
            MainActivity.sendsms(params[0] , params[1]) ;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}

//39, 37, 5.1, 19.05, 5572 , 20 ,80, 25, 145, 35, 5.02, 2.01, 5.4 ;





