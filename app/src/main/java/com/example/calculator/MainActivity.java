package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private EditText numberanswer;
    private EditText numbertext;
    private String curr, res;
    private Button zerobtn, onebtn, twobtn, threebtn, fourbtn, fivebtn, sixbtn, sevenbtn, eightbtn, ninebtn, dotbtn;

    private Button addbtn, minusbtn, timesbtn, dividebtn, clearbtn, equalsbtn;
    private boolean dot_put, operator_inserted;

    private ImageButton backbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberanswer = (EditText) findViewById(R.id.numberanswer);
        numbertext = (EditText) findViewById(R.id.numbertext);
        numberanswer.setInputType(0);
        numbertext.setInputType(0);

        zerobtn = (Button) findViewById(R.id.buttonzero);
        onebtn = (Button) findViewById(R.id.buttonone);
        twobtn = (Button) findViewById(R.id.buttontwo);
        threebtn = (Button) findViewById(R.id.buttonthree);
        fourbtn = (Button) findViewById(R.id.buttonfour);
        fivebtn = (Button) findViewById(R.id.buttonfive);
        sixbtn = (Button) findViewById(R.id.buttonsix);
        sevenbtn = (Button) findViewById(R.id.buttonseven);
        eightbtn = (Button) findViewById(R.id.buttoneight);
        ninebtn = (Button) findViewById(R.id.buttonnine);

        dotbtn = (Button) findViewById(R.id.pointbutton);
        addbtn = (Button) findViewById(R.id.addbutton);
        minusbtn = (Button) findViewById(R.id.minusbutton);
        timesbtn = (Button) findViewById(R.id.timesbutton);
        dividebtn = (Button) findViewById(R.id.dividebutton);
        equalsbtn = (Button) findViewById(R.id.equalsbutton);
        clearbtn = (Button) findViewById(R.id.clearbutton);

        backbtn = (ImageButton) findViewById(R.id.backbutton);

        curr = "";
        res = "";
        dot_put = false;
        operator_inserted = false;

        zerobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "0";
                displayOne();
            }
        });

        onebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "1";
                displayOne();
            }
        });

        twobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "2";
                displayOne();
            }
        });

        threebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "3";
                displayOne();
            }
        });

        fourbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "4";
                displayOne();
            }
        });

        fivebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "5";
                displayOne();
            }
        });

        sixbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "6";
                displayOne();
            }
        });

        sevenbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "7";
                displayOne();
            }
        });

        eightbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "8";
                displayOne();
            }
        });

        ninebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "9";
                displayOne();
            }
        });

        dotbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curr.isEmpty()) {
                    curr = "0.";
                    dot_put = true;
                }
                if (dot_put == false) {
                    curr = curr + ".";
                    dot_put = true;
                    displayOne();
                }
            }
        });

        dividebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_put = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        goback();
                    }
                    if (operator_inserted == false) {
                        curr = curr + " / ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });

        timesbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_put = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        goback();
                    }
                    if (operator_inserted == false) {
                        curr = curr + " * ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });

        minusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_put = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        goback();
                    }
                    if (operator_inserted == false) {
                        curr = curr + " - ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dot_put = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1, curr.length()).equals(".")) {
                        goback();
                    }
                    if (operator_inserted == false) {
                        curr = curr + " + ";
                        operator_inserted = true;
                    }
                }
                displayOne();
            }
        });


    equalsbtn.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick (View v) {
            if (operator_inserted == true && !curr.substring(curr.length() - 1, curr.length()).equals(" ")) {
                String[] tokens = curr.split(" ");

                switch (tokens[1].charAt(0)) {
                    case '+':
                        res = Double.toString(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]));
                        break;
                    case '-':
                        res = Double.toString(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]));
                        break;
                    case '*':
                        res = Double.toString(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]));
                        break;
                    case '/':
                        res = Double.toString(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]));
                        break;
                }
                displayTwo();
            }
        }
    });

        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
                displayOne();
                displayTwo();
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goback();
                displayOne();
            }
        });

        displayOne();
        displayTwo();
    }

    public void displayOne() {
        numbertext.setText(curr);
    }

    public void displayTwo() {
        numberanswer.setText(res);
    }

    public void clear(){
        curr = "";
        res = "";
        dot_put = false;
        operator_inserted = false;
    }

    public void goback(){
        if (!curr.isEmpty()){
            if (curr.substring(curr.length()-1, curr.length()).equals(".")){
                dot_put = false;
            }
            if (curr.substring(curr.length()-1, curr.length()).equals(" ")){
                curr = curr.substring(0, curr.length()-3);
                operator_inserted = false;
            }else{
                curr = curr.substring(0, curr.length()-1);
            }

        }
    }
}
