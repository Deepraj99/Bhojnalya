package com.example.bhojnalya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        boolean isStudent = bundle.getBoolean("is_student");

        TextView txt = findViewById(R.id.text3);
        if(isStudent)
            txt.setText("Student");
        else
            txt.setText("Vendor");

    }
}