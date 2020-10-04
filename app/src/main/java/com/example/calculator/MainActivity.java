package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button doubleZero;
    private Button dot;
    private Button clear;
    private ImageButton back;
    private Button plus;
    private Button minus;
    private Button multiply;
    private Button divide;
    private Button equal;
    public TextView resultUpper;
    public TextView resultLower;
    Double result = null;
    String resultString ="";
    String intermediate = "";
    String previousOperation ="";
    boolean haveDot = false;
    private boolean sizeFull = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        initializeButton();


    }

    public void initializeButton() {
        zero = (Button) findViewById(R.id.btn0);


        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        doubleZero = (Button)findViewById(R.id.btn00);
        dot = (Button)findViewById(R.id.btnDot);
        plus = (Button)findViewById(R.id.btnPlus);
        minus = (Button)findViewById(R.id.btnMinus);
        multiply = (Button)findViewById(R.id.btnMultiply);
        divide = (Button)findViewById(R.id.btnDivide);
        clear = (Button)findViewById(R.id.btnClear);
        back = (ImageButton) findViewById(R.id.btnBack);
        equal = (Button)findViewById(R.id.btn_equal);

        resultUpper = (TextView)findViewById(R.id.resultUpper);

        resultLower = (TextView)findViewById(R.id.resultLower);
        buttonEffect(zero);
        buttonEffect(one);
        buttonEffect(two);
        buttonEffect(three);
        buttonEffect(four);
        buttonEffect(five);
        buttonEffect(six);
        buttonEffect(seven);
        buttonEffect(eight);
        buttonEffect(nine);
        buttonEffect(zero);
        buttonEffect(clear);
        buttonEffect(doubleZero);
        buttonEffect(back);
        buttonEffect(equal);
        buttonEffect(divide);
        buttonEffect(multiply);
        buttonEffect(clear);
        buttonEffect(dot);
        buttonEffect(plus);
        buttonEffect(minus);
    }

    public void onCClicked(View view){
        Log.d(TAG, "onCClicked: ");

        calculateResult("C");

    }



    public void onBackClicked(View view){
        //Log.d(TAG, "onCClicked: ");

        calculateResult("Back");
    }

    public void onMultiplyClicked(View view){
        //Log.d(TAG, "onCClicked: ");

        calculateResult("Multiply");
    }

    public void onDivideClicked(View view){
        //Log.d(TAG, "onCClicked: ");

        calculateResult("Divide");
    }

    public void onPlusClicked(View view){
        //Log.d(TAG, "onCClicked: ");

        calculateResult("Plus");
    }

    public void onMinusClicked(View view){
        //Log.d(TAG, "onCClicked: ");

        calculateResult("Minus");
    }

    public void onEqualClicked(View view){
        //Log.d(TAG, "onCClicked: ");

        calculateResult("Equal");
    }

    public void onDotClicked(View view){
        //Log.d(TAG, "onCClicked: ");

        calculateResult("Dot");
    }

    public void on0Clicked(View view){
        //Log.d(TAG, "onCClicked: ");

        calculateResult("0");
    }

    public void on00Clicked(View view){
        //Log.d(TAG, "onCClicked: ");

        calculateResult("00");
    }

    public void on1Clicked(View view){
        //Log.d(TAG, "onCClicked: ");

        calculateResult("1");
    }

    public void on2Clicked(View view){
        //Log.d(TAG, "onCClicked: ");

        calculateResult("2");
    }

    public void on3Clicked(View view){
        //Log.d(TAG, "onCClicked: ");

        calculateResult("3");
    }

    public void on4Clicked(View view){
        //Log.d(TAG, "onCClicked: ");

        calculateResult("4");
    }

    public void on5Clicked(View view){
        //Log.d(TAG, "onCClicked: ");
        calculateResult("5");

    }

    public void on6Clicked(View view){
        //Log.d(TAG, "onCClicked: ");
        calculateResult("6");

    }

    public void on7Clicked(View view){
        //Log.d(TAG, "onCClicked: ");
        calculateResult("7");

    }

    public void on8Clicked(View view){
        //Log.d(TAG, "onCClicked: ");
        calculateResult("8");

    }

    public void on9Clicked(View view){
        //Log.d(TAG, "onCClicked: ");
        calculateResult("9");

    }

    private void calculateResult(String str) {

        if(str == "Equal"){
            Log.d(TAG, "calculateResult: Equal");
            onEqual();
        }else if(str == "C"){
            onClear();
            Log.d(TAG, "calculateResult: C");
        }else if(str == "0" || str == "00" || str == "1" || str == "2" || str == "3" || str == "4" || str == "5" || str == "6" || str == "7" || str == "8" || str == "9"){
            onNumber(str);
            Log.d(TAG, "calculateResult: "+str);
        }else if(str == "Back"){
            onBack();
            Log.d(TAG, "calculateResult: "+str);
        }else if(str == "Plus" || str == "Minus" || str == "Multiply" || str == "Divide"){
            onOperation(str);
            Log.d(TAG, "calculateResult: "+str);
        }else if(str == "Dot"){
            onDot();
            Log.d(TAG, "calculateResult: "+str);
        }
    }

    public static void buttonEffect(View button){
        button.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        v.getBackground().setColorFilter(0xe0f47521, PorterDuff.Mode.SRC_ATOP);
                        v.invalidate();
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        v.getBackground().clearColorFilter();
                        v.invalidate();
                        break;
                    }
                }
                return false;
            }
        });
    }
    private void onEqual() {
        if(sizeFull)return;
        if(intermediate.length() == 0) return;
        if(previousOperation.length() > 0){
            switch (previousOperation){
                case "Plus":
                    result =result + Double.parseDouble(intermediate);
                    break;
                case "Minus":
                    result = result - Double.parseDouble(intermediate);
                    break;
                case "Multiply":
                    result = result * Double.parseDouble(intermediate);
                    break;
                case "Divide":
                    if(Double.parseDouble(intermediate) == 0){
                        resultLower.setText("Error");
                        return;
                    }
                    result = result / Double.parseDouble(intermediate);
                    break;

            }


            resultString = String.valueOf(result);
            previousOperation ="";
            intermediate = "";
            haveDot = true;
            updateLowerTextVIew(String.valueOf(result));
            updateUpperTextVIew("");
        }


    }

    private void onClear() {
        haveDot = false;
        result = null;
        previousOperation ="";
        resultString ="";
        intermediate ="";
        sizeFull = false;
        updateLowerTextVIew("");
        updateUpperTextVIew("");


    }

    private void onDot() {
        if(intermediate.length() >= 13) return;
        if(sizeFull)return;
        if(haveDot)return;
        haveDot = true;
        intermediate += ".";
        updateLowerTextVIew(intermediate);
    }

    void updateLowerTextVIew(String str){
        resultLower.setText(str);
    }

    void updateUpperTextVIew(String str){
        resultUpper.setText(str);
    }

    private void onOperation(String str) {

        if(sizeFull) return;
        if(previousOperation.length() > 0){
            switch (previousOperation){
                case "Plus":
                    result =result + Double.parseDouble(intermediate);
                    //resultString =resultString + intermediate + " + " ;
                    break;
                case "Minus":
                    result = result - Double.parseDouble(intermediate);
                    //resultString =resultString + intermediate + " - " ;
                    break;
                case "Multiply":
                    result = result * Double.parseDouble(intermediate);
                    //resultString =resultString + intermediate + " * " ;
                    break;
                case "Divide":
                    if(Double.parseDouble(intermediate) == 0){
                        resultLower.setText("Error");
                        return;
                    }
                    result = result / Double.parseDouble(intermediate);
                    //resultString =resultString + intermediate + " / " ;
                    break;

            }



        }else {
            if(intermediate.length() >0)
                 result = Double.parseDouble(intermediate);

        }

        switch (str){
            case "Plus":

                resultString =resultString + intermediate + " + " ;
                break;
            case "Minus":

                resultString =resultString + intermediate + " - " ;
                break;
            case "Multiply":

                resultString =resultString + intermediate + " * " ;
                break;
            case "Divide":

                resultString =resultString + intermediate + " / " ;
                break;

        }
        previousOperation = str;

        updateUpperTextVIew(resultString);
        if(resultString.length() >= 26 ){
            updateLowerTextVIew(String.valueOf(result));
            sizeFull = true;
        }else {
            updateLowerTextVIew("");
        }

        intermediate ="";
    }

    private void onBack() {
        if(sizeFull)return;
        if(intermediate.length() == 0) return;
        if(intermediate.charAt(intermediate.length() -1) == '.') haveDot = false;

        intermediate = intermediate.substring(0,intermediate.length()-1);
        updateLowerTextVIew(intermediate);
    }

    private void onNumber(String str) {

        if(sizeFull)return;
        if(intermediate.length() >= 13) return;
        intermediate += str;
        updateLowerTextVIew(intermediate);
    }

}
