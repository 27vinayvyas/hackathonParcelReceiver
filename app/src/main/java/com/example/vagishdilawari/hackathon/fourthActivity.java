package com.example.vagishdilawari.hackathon;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.String;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Gravity;
import android.content.Intent;
import android.net.Uri;


public class fourthActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName1,editPhone1,editID1,editName2,editPhone2,editID2,editName3,editPhone3,editID3,editName4,editPhone4,editID4,editName5,editPhone5,editID5;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;
    Button btnviewUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_fourth);
        myDb = new DatabaseHelper(this);

        editName1 = (EditText)findViewById(R.id.editText1);

        editPhone1 = (EditText)findViewById(R.id.editText2);

        editID1=(EditText)findViewById(R.id.editTextid1);

        btnAddData = (Button)findViewById(R.id.insert);
        btnviewAll = (Button)findViewById(R.id.view);
        btnviewUpdate= (Button)findViewById(R.id.update);
        btnDelete= (Button)findViewById(R.id.delete);

        AddData();
        viewAll();
        UpdateData();
        DeleteData();

    }



    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editID1.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(fourthActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(fourthActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editID1.getText().toString(),
                                editName1.getText().toString(),
                                editPhone1.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(fourthActivity.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(fourthActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editID1.getText().toString(),
                                editName1.getText().toString(),
                                editPhone1.getText().toString());
                        if(isInserted == true)
                            Toast.makeText(fourthActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(fourthActivity.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }






    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Error", "Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :" + res.getString(0) + "\n");
                            buffer.append("Name :" + res.getString(1) + "\n");
                            buffer.append(":" + res.getString(2) + "\n\n");
                        }

                        // Show all data
                        showMessage("Data", buffer.toString());

                    }
                }
        );
    }







    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }





}