package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class implisitActivity extends AppCompatActivity {
    private EditText edit_Url;
    private EditText edit_Lokasi;
    private EditText edit_ShareText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implisit_activity);
        edit_Url = findViewById(R.id.editUrl);
        edit_Lokasi = findViewById(R.id.editLokasi);
        edit_ShareText = findViewById(R.id.editShareText);
    }

    public void OpenWebsite(View view) {
        String url = edit_Url.getText().toString();
        Uri webpage =  Uri.parse(url);
        Intent a = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(a);
    }

    public void OpenLokasi(View view) {
        String geoUri = "geo: Surakarta";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Aplikasi pemetaan tidak tersedia.", Toast.LENGTH_SHORT).show();
        }
    }

    public void ShareText(View view) {
        Intent z = new Intent();
        z.setAction(Intent.ACTION_SEND);
        z.setType("text/plain");
        z.putExtra(Intent.EXTRA_TEXT, "Teks ini saya bagikan melalui implicit intent!");
        startActivity(Intent.createChooser(z, "Bagikan dengan"));
    }

    public void openMainActivity(View view) {
        Intent i =new Intent(this, MainActivity.class);
        startActivity(i);
    }
}