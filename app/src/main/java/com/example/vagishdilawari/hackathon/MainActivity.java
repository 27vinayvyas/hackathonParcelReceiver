package com.example.vagishdilawari.hackathon;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.lang.String;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Gravity;
import android.content.Intent;
import android.net.Uri;


public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);


    }

    public StringBuffer buffer = new StringBuffer();
    public String a[] = new String[5];
    public String st=new String();
    public int b[]=new int[5];


    public void loop(){

        for(int i=0;i<54;i++)
        {
            st+=buffer.charAt(i);
        }
      //  for(int i=0;i<5;i++){
       //     b[i]=Integer.parseInt(a[i]);
        //}

    }



    public String number;
    public String location;
    public int switch1 = 1;
    public int switch2 = 1;
    public int count=0;


    public void switchOn1(View view) {
        if (switch1 == 1)
            switch1 = 0;
        else if (switch1 == 0)
            switch1 = 1;
    }

    public void switchOn2(View view) {
        if (switch2 == 1)
            switch2 = 0;
        else if (switch2 == 0)
            switch2 = 1;
    }


    public void delivery(View view) {


        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            // show message
           // showMessage("Error", "Nothing found");
            return;
        }


        while (res.moveToNext()) {

            buffer.append(res.getString(2)+";");
        }

        // Show all data



        loop();


        EditText phone = (EditText) findViewById(R.id.delivery_number);
        number = phone.getText().toString();

        EditText parcel = (EditText) findViewById(R.id.delivery_location);
        location = parcel.getText().toString();

        count=0;

        for(int i=0;i<number.length();i++)
        {
            char c=number.charAt(i);
            int ascii=(int)(c);
            if(ascii<48 || ascii>57)
            {
                count++;
                break;
            }
        }

        if(number.length() == 0 && location.length() == 0 && switch1 == 0 && switch2 == 0)
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter atleast 1 field", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 450);
            toast.show();
        }
        else if (number.length() !=10 && number.length() != 0 ) {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter a 10 digit phone number", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 450);
            toast.show();}
        else if (count>0 ) {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter a valid phone number", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 450);
            toast.show();}
            else if (number.length() == 0 && switch1 == 1) {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter phone number of delivery boy", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 450);
            toast.show();
        } else if (location.length() == 0 && switch2 == 1) {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter location of delivery boy", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 450);
            toast.show();
        }

        else {
            launchsms();
        }
    }



    public void launchsms() {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", st, null));
        intent.putExtra("sms_body", "Hey! I would like to inform you that I'm not available to receive my parcel that has arrived just now due to some engagement. The phone number of the delivery boy is " + number + " and he is at " + location + ". It would be polite of you to receive my parcel.\n-Vagish");
        startActivity(intent);
    }

    public void fourth(View view)
    {
        Intent intent = new Intent(this, fourthActivity.class);
        startActivity(intent);
    }

    public void NActivity(View view) {
        EditText phone = (EditText) findViewById(R.id.delivery_number);
        number = phone.getText().toString();

        EditText parcel = (EditText) findViewById(R.id.delivery_location);
        location = parcel.getText().toString();

        count=0;

        for(int i=0;i<number.length();i++)
        {
            char c=number.charAt(i);
            int ascii=(int)(c);
            if(ascii<48 || ascii>57)
            {
                count++;
                break;
            }
        }


        if(number.length() == 0 && location.length() == 0 && switch1 == 0 && switch2 == 0)
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter atleast 1 field", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 450);
            toast.show();
        }
        else if (number.length() !=10 && number.length() != 0 ) {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter a 10 digit phone number", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 450);
            toast.show();}
        else if (count>0 ) {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter a valid phone number", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 450);
            toast.show();}
        else if (number.length() == 0 && switch1 == 1) {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter phone number of delivery boy", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 450);
            toast.show();
        } else if (location.length() == 0 && switch2 == 1) {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter location of delivery boy", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 450);
            toast.show();
        }

        else {
            Intent intent = new Intent(this, nextActivity.class);
            startActivity(intent);
        }

    }
}

