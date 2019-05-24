package com.heroesapi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import heroesapi.HeroesAPI;
import model.Heroes;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import url.Url;

public class DashboardActivity extends AppCompatActivity {
    private Button btnRegister, btnView, btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnRegister = findViewById(R.id.btnRegister);
        btnView = findViewById(R.id.btnView);
        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:3000/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                HeroesAPI heroesAPI = retrofit.create(HeroesAPI.class);
                Call<List<Heroes>> logout = heroesAPI.logout();

                logout.enqueue(new Callback<List<Heroes>>() {
                    @Override
                    public void onResponse(Call<List<Heroes>> call, Response<List<Heroes>> response) {
                        if (response.isSuccessful()){
                            Intent intent = new Intent(DashboardActivity.this,LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Heroes>> call, Throwable t) {
                        Toast.makeText(DashboardActivity.this,"error",Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

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
