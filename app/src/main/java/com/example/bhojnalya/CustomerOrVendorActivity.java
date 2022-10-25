package com.example.bhojnalya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CustomerOrVendorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_or_vendor);

        Button studentButton = findViewById(R.id.student_button);
        Button vendorButton = findViewById(R.id.vendor_button);

        Intent i = new Intent(CustomerOrVendorActivity.this, MainActivity.class);
        studentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                i.putExtra("is_student", true);
                startActivity(i);
            }
        });

        vendorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CustomerOrVendorActivity.this, MainActivity.class);
                i.putExtra("is_student", false);
                startActivity(i);
            }
        });
    }
}