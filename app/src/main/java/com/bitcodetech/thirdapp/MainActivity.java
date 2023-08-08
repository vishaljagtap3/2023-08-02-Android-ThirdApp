package com.bitcodetech.thirdapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtUsername;
    private ImageView imgUser;
    private EditText edtUsername;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnStart.setOnClickListener(new BtnStartClickListener());


    }

    private class BtnStartClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Intent intentUserActivity =
                    new Intent(MainActivity.this, UserActivity.class);

            //put data
            intentUserActivity.putExtra("name", edtUsername.getText().toString());
            intentUserActivity.putExtra("id", 109089);

            startActivity(intentUserActivity);
        }
    }

    private void initViews() {
        txtUsername = findViewById(R.id.txtUsername);
        imgUser = findViewById(R.id.imgUser);
        edtUsername = findViewById(R.id.edtUsername);
        btnStart = findViewById(R.id.btnStart);
    }
}