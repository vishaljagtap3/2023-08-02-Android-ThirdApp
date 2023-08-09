package com.bitcodetech.thirdapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
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

    private int selectedImageId = R.drawable.flag_ind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.user_activity);
        initViews();
        processInput();

        btnSet.setOnClickListener(new BtnSetOnClickListener());
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImageId = R.drawable.flag_ind;
                img1.setBackgroundColor(Color.BLUE);
                img2.setBackgroundColor(Color.WHITE);
                img3.setBackgroundColor(Color.WHITE);
                img4.setBackgroundColor(Color.WHITE);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImageId = R.drawable.flag_germany;
                img2.setBackgroundColor(Color.BLUE);
                img1.setBackgroundColor(Color.WHITE);
                img3.setBackgroundColor(Color.WHITE);
                img4.setBackgroundColor(Color.WHITE);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImageId = R.drawable.flag_usa;
                img3.setBackgroundColor(Color.BLUE);
                img2.setBackgroundColor(Color.WHITE);
                img1.setBackgroundColor(Color.WHITE);
                img4.setBackgroundColor(Color.WHITE);
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedImageId = R.drawable.flag_france;
                img4.setBackgroundColor(Color.BLUE);
                img2.setBackgroundColor(Color.WHITE);
                img3.setBackgroundColor(Color.WHITE);
                img1.setBackgroundColor(Color.WHITE);
            }
        });
    }

    private class BtnSetOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("result_text", edtInfo.getText().toString());
            resultIntent.putExtra("result_image_id", selectedImageId);

            setResult(1, resultIntent);
            finish();
        }
    }

    private void processInput() {
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        int id = i.getIntExtra("id", -1);

        /*Bundle input = i.getExtras();
        String name = input.getString("name");
        int id = input.getInt("id", -1);*/

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