package com.example.vagishdilawari.hackathon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.lang.String;
import android.widget.EditText;
import android.widget.Toast;
import android.view.Gravity;
import android.content.Intent;
import android.net.Uri;


public class nextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
    }

    public void back(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        finish();
        startActivity(intent);
    }

    public void sendMsg(View view)
    {
        MainActivity obj=new MainActivity();
        String number=obj.number;
        String location=obj.location;
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "9414901949;9775020079;9131981203;7300912106;9950606917", null));
        intent.putExtra("sms_body", "Hey! I would like to inform you that I'm not available to receive my parcel that has arrived just now due to some engagement. The phone number of the delivery boy is " + number + " and he is at " + location + ". It would be polite of you to receive my parcel.Please reply me in a YES or NO asap.\n-Vagish");
        startActivity(intent);
    }

    public void inform(View view)
    {
        Intent intent = new Intent(this, thirdActivity.class);
        startActivity(intent);
    }

}

