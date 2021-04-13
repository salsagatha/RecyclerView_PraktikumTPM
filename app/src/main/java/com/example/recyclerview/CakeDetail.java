package com.example.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class CakeDetail extends AppCompatActivity {
    TextView tvNamaKue, tvDeskripsiKue;
    ImageView ivFotoKue;

    String namaKue, deskripsiKue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cakedetail_activity);

        tvNamaKue = findViewById(R.id.tvNamaKue);
        tvDeskripsiKue = findViewById(R.id.tvDeskripsiKue);
        ivFotoKue = findViewById(R.id.ivCake);

        namaKue = getIntent().getStringExtra("namaKue");
        deskripsiKue = getIntent().getStringExtra("deskripsiKue");

        tvNamaKue.setText(namaKue);
        tvDeskripsiKue.setText(deskripsiKue);
    }

}
