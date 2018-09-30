package com.example.vagishdilawari.hackathon;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.lang.String;

import android.widget.Button;
import	android.widget.TextView;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Gravity;
import android.content.Intent;
import android.net.Uri;

public class thirdActivity extends AppCompatActivity {

    // Button btn=(Button)findViewById(R.id.lacncheeee);

    DatabaseHelper myDb;
    //TextView editText=(TextView) findViewById(R.id.et);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        myDb = new DatabaseHelper(this);



    }


   // textView1


    public void CALL(){



        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            // show message
            // showMessage("Error", "Nothing found");
            return;
        }




        while (res.moveToNext()) {

            buffer.append(res.getString(1) + ";");
            buffer1.append(res.getString(2) + ";");
        }

        loop();
        loop1();


    }



    public StringBuffer buffer=new StringBuffer();
    public StringBuffer buffer1=new StringBuffer();
    public  int n;

    public String a[]=new String [5];
    public String a1[]=new String [5];

    int j=0;
    public void loop() {
        for (int i = 0; i < buffer.length(); i++) {
            if (buffer.charAt(i) == ';') {
                j++;
                continue;
            }
            a[j] += buffer.charAt(i);

        }

    }
    int k=0;
    public void loop1() {
        for (int i = 0; i < buffer1.length(); i++) {
            if (buffer1.charAt(i) == ';') {
                k++;
                continue;
            }
            a1[k] += buffer1.charAt(i);

        }

    }

    public String xx=new String();
    public String xxxx=new String();

    public void loop2(){
        for(int i=0;i<43;i++){
            xxxx+=xx.charAt(i);
        }

    }


    public void paytm(View view) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("net.one97.paytm");
        startActivity(launchIntent);




    }

    public void btn1(View view)
    {
        CALL();
        n=1;
    }


    public void btn2(View view)
    {    CALL();
        n=2;
    }
    public void btn3(View view)
    {    CALL();
        n=3;
    }
    public void btn4(View view)
    {    CALL();
        n=4;
    }
    public void btn5(View view)
    {    CALL();
        n=5;
    }
    public void launch(View view)
    {

        for (int i=0;i<5;i++){
            if(i==n){
                continue;
            }
            xx+=a1[i];
            xx+=";";
        }

        loop2();

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", xxxx, null));
        intent.putExtra("sms_body", "Please ignore my previous message of receiving my parcel as it has been received.Thanks for your concern shown.\n-Vagish");
        finish();
        startActivity(intent);
    }

    public void baack(View view){
        Intent intent = new Intent(this, nextActivity.class);
        startActivity(intent);
    }


}
