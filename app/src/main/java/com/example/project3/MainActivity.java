package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    public static final String EXTRA_MESSAGE="MESSAGE";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.editText);
        textView=findViewById(R.id.text_message);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView.setText(message);
    }

    public void openSecondActivity(View view) {
        Intent intent=new Intent(this, SecondActivity.class);
        String message=editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }

    public void openImplicitActivity(View view) {
        Intent a =new Intent(this, implisitActivity.class);
        startActivity(a);
    }
}