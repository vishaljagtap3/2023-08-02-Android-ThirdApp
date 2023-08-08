package com.bitcodetech.thirdapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class UserActivity extends Activity {

    private TextView txtInfo;
    private EditText edtInfo;
    private ImageView img1, img2, img3, img4;
    private Button btnSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.user_activity);
        initViews();
        processInput();
    }

    private void processInput() {
        Intent i = getIntent();
        Bundle input = i.getExtras();
        String name = input.getString("name");
        int id = input.getInt("id");
        Toast.makeText(this, name + " " + id, Toast.LENGTH_LONG).show();
        txtInfo.setText(name + " " + id);
    }

    private void initViews() {
        txtInfo = findViewById(R.id.txtInfo);
        edtInfo = findViewById(R.id.edtInfo);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        btnSet = findViewById(R.id.btnSet);
    }
}