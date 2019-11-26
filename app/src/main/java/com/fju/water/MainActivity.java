package com.fju.water;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edMonth;

    boolean isNext = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        edMonth = findViewById(R.id.month);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Switch sw = findViewById(R.id.sw);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                isNext = isChecked;
                TextView text = findViewById(R.id.type);
                text.setText(isNext ? getString(R.string.every_other_month) : getString(R.string.monthly));
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

    }


    public void reset(){
        String message = "";
        edMonth.setText(message);
        //edNext.setText(message);
    }


    public void calculate() {

        DialogInterface.OnClickListener listner = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reset();
            }
        };
        if (!TextUtils.isEmpty(edMonth.getText().toString())) {
            float num = Float.parseFloat(edMonth.getText().toString());
            double money = 0;
            if (num >= 1 && num <= 10) {
                money = num * 7.35;
//                new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("每月抄表費用")
//                        .setMessage("費用"+ money)
//                        .setPositiveButton("OK",listner)
//                        .show();
//            }else if(num>=11 && num<=30){
//                    money= num*9.45-21;
//                  new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("每月抄表費用")
//                        .setMessage("費用"+ money)
//                        .show();
//              }else if(num>=31 && num<=50){
//                    money= num*11.55-84;
//                 new AlertDialog.Builder(MainActivity.this)
//                          .setTitle("每月抄表費用")
//                            .setMessage("費用"+ money)
//                         .setPositiveButton("OK",listner)
//                         .show();
//                }else if (num>50){
//                    money= num*12.075-110.25;
//                  new AlertDialog.Builder(MainActivity.this)
//                           .setTitle("每月抄表費用")
//                           .setMessage("費用"+ money)
//                           .setPositiveButton("OK",listner)
//                            .show();
//                }

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra(getString(R.string.extra_money), money);
                startActivity(intent);

//            } else if (TextUtils.isEmpty(edMonth.getText().toString()) && !TextUtils.isEmpty(edNext.getText().toString())) {
//                float number = Float.parseFloat(edNext.getText().toString());
//                if (number >= 1 && number <= 20) {
//                    money = number * 7.35;
//                    new AlertDialog.Builder(MainActivity.this)
//                            .setTitle("隔月抄表費用")
//                            .setMessage("費用" + money)
//                            .setPositiveButton("OK", listner)
//                            .show();
//                } else if (number >= 21 && number <= 60) {
//                    money = number * 9.45 - 42;
//                    new AlertDialog.Builder(MainActivity.this)
//                            .setTitle("隔月抄表費用")
//                            .setMessage("費用" + money)
//                            .setPositiveButton("OK", listner)
//                            .show();
//                } else if (number >= 61 && number <= 100) {
//                    money = number * 11.55 - 168;
//                    new AlertDialog.Builder(MainActivity.this)
//                            .setTitle("隔月抄表費用")
//                            .setMessage("費用" + money)
//                            .setPositiveButton("OK", listner)
//                            .show();
//                } else if (number > 100) {
//                    money = number * 12.075 - 220.5;
//                    new AlertDialog.Builder(MainActivity.this)
//                            .setTitle("隔月抄表費用")
//                            .setMessage("費用" + money)
//                            .setPositiveButton("OK", listner)
//                            .show();
//                }
//            } else if (TextUtils.isEmpty(edMonth.getText().toString()) && TextUtils.isEmpty(edNext.getText().toString())) {
//                new AlertDialog.Builder(MainActivity.this)
//                        .setTitle("錯誤")
//                        .setMessage("請輸入數值")
//                        .setPositiveButton("OK", listner)
//                        .show();
//
            }

        }
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
