package com.bilgic.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    SharedPreferences sharedPreferences;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView);

        sharedPreferences = this.getSharedPreferences("com.bilgic.myapplication", Context.MODE_PRIVATE);
        int storedAge = sharedPreferences.getInt("storedAge", 0);

        if (storedAge == 0) {
            textView.setText("Your age:");
        } else {
            textView.setText("Your age: " + storedAge);
        }
    }

    @SuppressLint("SetTextI18n")
    public void save(View view) {
        String input = editText.getText().toString().trim();
        if (!input.isEmpty()) {
            try {
                int number = Integer.parseInt(input);
                textView.setText("Your age: " + number);
                sharedPreferences.edit().putInt("storedAge", number).apply();
            } catch (NumberFormatException e) {
                textView.setText("Invalid input! Please enter a number.");
            }
        } else {
            textView.setText("Please enter a valid age.");
        }
    }
    @SuppressLint("SetTextI18n")
    public void delete(View view){
        int storedData = sharedPreferences.getInt("storedAge", 0);
        if (storedData != 0){
            sharedPreferences.edit().remove("storedAge").apply();
            textView.setText("Your age: ");
        }
    }
}
