package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {

    private String num1="";
    private String num2="";
    private String result="";
    private String operator="";

    private TextView output;

    private HashSet<String> operators=new HashSet<String>(){{add("\\+");add("\\-");add("\\x");add("\\/");}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output=findViewById(R.id.output);
    }

    public void onClickNumber(View view){
        Button button=(Button) view;
        String buttonText=(String) button.getText();
        if (operator.equals("")){
            num1+=buttonText;
        }
        else{
            num2+=buttonText;
        }
        updateOutputLabel();
    }

    public void onClickOperator(View view){
        if (!operator.equals("")){
            return;
        }
        if (num1.equals("")){
            return;
        }
        Button button=(Button) view;
        String buttonText=(String) button.getText();
        operator=buttonText;
        updateOutputLabel();
    }

    public void onClickEqual(View view){
        if (num1.equals("") || num2.equals("") || operator.equals("")){
            return;
        }
        if (num1.equals(".")){
            num1="0";
        }
        if (num2.equals(".")){
            num2="0";
        }
        double num1Number=0;
        double num2Number=0;
        double resultNumber=0;
        num1Number=Double.parseDouble(num1);
        num2Number=Double.parseDouble(num2);
        if (operator.equals("+")){
            resultNumber=num1Number+num2Number;
        }
        else if (operator.equals("-")){
            resultNumber=num1Number-num2Number;
        }
        else if (operator.equals("x")){
            resultNumber=num1Number*num2Number;
        }
        else if (operator.equals("/")){
            resultNumber=num1Number/num2Number;
        }
        result=Double.toString(resultNumber);
        if (resultNumber%1==0){
            result=result.substring(0, result.length()-2);
        }
        output.setText(result);
        clearVariables();

    }

    public void onClickDot(View view){
        if (operator.equals("")){
            if (!num1.contains(".")){
                num1+=".";
            }
        }
        else{
            if (!num2.contains(".")){
                num2+=".";
            }
        }
        updateOutputLabel();
    }

    public void onClickClear(View view){
        clearVariables();
        updateOutputLabel();
    }

    private void updateOutputLabel(){
        output.setText(num1+operator+num2);
    }

    private void clearVariables(){
        num1="";
        num2="";
        result="";
        operator="";
    }
}