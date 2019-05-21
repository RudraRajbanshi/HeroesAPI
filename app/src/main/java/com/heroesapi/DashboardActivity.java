package com.heroesapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {
    private Button btnRegister, btnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnRegister = findViewById(R.id.btnRegister);
        btnView = findViewById(R.id.btnView);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,ImageActivity.class);
                startActivity(intent);
            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
