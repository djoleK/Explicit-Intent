package com.example.explicitintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    Button btnAct2, btnAct3;
    TextView tvResults;
    final int ACTIVITY3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        btnAct2 = findViewById(R.id.btnAct2);
        btnAct3 = findViewById(R.id.btnAct3);
        tvResults = findViewById(R.id.tvResults);


    }

    public void clickAct2(View view) {

        if (etName.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Please enter your name", Toast.LENGTH_SHORT);
        } else {
            String name = etName.getText().toString().trim();
            Intent intent = new Intent(MainActivity.this, com.example.explicitintent.Activity2.class);
            intent.putExtra("name", name);
            startActivity(intent);
        }
    }

    public void clickAct3(View view) {
        Intent intent = new Intent(MainActivity.this, com.example.explicitintent.Activity3.class);
        startActivityForResult(intent, ACTIVITY3);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ACTIVITY3 && resultCode == RESULT_OK) {
            String surname = data.getStringExtra("surname");
            tvResults.setText(surname);
        } else {
            tvResults.setText("No data received!");
        }
    }


}
