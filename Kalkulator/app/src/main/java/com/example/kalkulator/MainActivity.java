package com.example.kalkulator;

import static java.lang.Math.pow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Stack;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    String liczba = "";
    double result;
    boolean flaga = false;
    ArrayList<String> lista = new ArrayList<>();
    public void onClick(View view) {

        Button przycisk = (Button)view;
        String dzialanie = (String)przycisk.getText();
        TextView wynik = (TextView)findViewById(R.id.historyText);
        if (flaga == true){
            liczba = String.valueOf(result);
            flaga = false;
        } else {
        switch (dzialanie) {
            case "1":
                liczba = liczba + "1";
                break;
            case "2":
                liczba = liczba + "2";
                break;
            case "3":
                liczba = liczba + "3";
                break;
            case "4":
                liczba = liczba + "4";
                break;
            case "5":
                liczba = liczba + "5";
                break;
            case "6":
                liczba = liczba + "6";
                break;
            case "7":
                liczba = liczba + "7";
                break;
            case "8":
                liczba = liczba + "8";
                break;
            case "9":
                liczba = liczba + "9";
                break;
            case "0":
                liczba = liczba + "0";
                break;
            case "Num":
                liczba = liczba + "**";
                break;
            case "+":
                liczba = liczba + "+";
                break;
            case "-":
                liczba = liczba + "-";
                break;
            case "*":
                liczba = liczba + "*";
                break;
            case "/":
                liczba = liczba + "/";
                break;
            case ".":
                liczba = liczba + ".";
                break;
        }
        }

        wynik.setText(liczba);
    }
    public void clean(View view) {
        TextView obliczenie = (TextView) findViewById(R.id.historyText);
        ImageButton cleanbut = (ImageButton)findViewById(R.id.imageButton);
        liczba = " ";
        flaga = false;
        obliczenie.setText("");
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim1);
        cleanbut.startAnimation(animation);
    }

    public void history(View view) {
        ImageButton cleanbut = (ImageButton)findViewById(R.id.imageButton2);
        Intent intent = new Intent("com.example.xx.kalkulator.HISTORY");
        intent.putStringArrayListExtra("lista", (ArrayList<String>) lista);
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim1);
        cleanbut.startAnimation(animation);
        startActivity(intent);
    }
    public void onClickCalc(View view) {
        TextView liczba = (TextView) findViewById(R.id.historyText);
        String obliczenie = liczba.getText().toString();

        obliczenie = obliczenie.replace("**", "^");
        String[] numbers = obliczenie.split("[\\+\\-\\*\\/\\^]");
        String[] operators = obliczenie.split("[0-9\\.]+");

        result = Double.parseDouble(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            double number = Double.parseDouble(numbers[i]);
            String operator = operators[i];

            if (operator.equals("^")) {
                result = Math.pow(result, number);
            } else {
                switch (operator) {
                    case "+":
                        result += number;
                        break;
                    case "-":
                        result -= number;
                        break;
                    case "*":
                        result *= number;
                        break;
                    case "/":
                        result /= number;
                        break;
                }
            }
        }
        liczba.setText(String.valueOf(result));
        /*obliczenie = obliczenie.replace("");*/
        lista.add(obliczenie + "=" + result);
        flaga = true;

    }
        }

