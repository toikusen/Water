package com.fju.water;

import android.content.DialogInterface;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edMonth;
    private EditText edNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edMonth = findViewById(R.id.month);
        edNext = findViewById(R.id.month);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });
    }

    public void reset(){
        edMonth.setText("");
        edNext.setText("");
    }

    public void month(){
        float degree1 = Float.parseFloat(edMonth.getText().toString());
        DialogInterface.OnClickListener listner1 = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reset();
            }
        };


        if(degree1<=10){
            double money= degree1*7.35;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("每月抄表費用")
                    .setMessage("費用"+ money)
                    .setPositiveButton("OK",listner1)
                    .show();
        }else if(degree1>10 && degree1<=30){
            double money= degree1*9.45-21;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("每月抄表費用")
                    .setMessage("費用"+ money)
                    .setPositiveButton("OK",listner1)
                    .show();
        }else if(degree1>30 && degree1<=50){
            double money= degree1*11.55-84;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("每月抄表費用")
                    .setMessage("費用"+ money)
                    .setPositiveButton("OK",listner1)
                    .show();
        }else if (degree1>50){
            double money= degree1*12.075-110.25;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("每月抄表費用")
                    .setMessage("費用"+ money)
                    .setPositiveButton("OK",listner1)
                    .show();
        }
    }

    public void next(){
        float degree = Float.parseFloat(edNext.getText().toString());
        DialogInterface.OnClickListener listner = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reset();
            }
        };
        if(degree<=20){
            double money= degree*7.35;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("隔月抄表費用")
                    .setMessage("費用"+ money)
                    .setPositiveButton("OK",listner)
                    .show();
        }else if(degree>20 && degree<=60){
            double money= degree*9.45-42;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("隔月抄表費用")
                    .setMessage("費用"+ money)
                    .setPositiveButton("OK",listner)
                    .show();
        }else if(degree>60 && degree<=100){
            double money= degree*11.55-168;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("隔月抄表費用")
                    .setMessage("費用"+ money)
                    .setPositiveButton("OK",listner)
                    .show();
        }else {
            double money= degree*12.075-220.5;
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("隔月抄表費用")
                    .setMessage("費用"+ money)
                    .setPositiveButton("OK",listner)
                    .show();
        }
    }


    public void calculate(View view){
       next();
       month();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
