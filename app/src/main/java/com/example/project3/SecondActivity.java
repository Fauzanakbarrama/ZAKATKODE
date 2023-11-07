package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editText2;

    public static final String EXTRA_MESSAGE="MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView=findViewById(R.id.text_message2);
        Intent intent=getIntent();
        String message=intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView.setText(message);
        editText2 = findViewById(R.id.editText2);
    }

    public void openSecondActivity2(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String message = editText2.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }
}