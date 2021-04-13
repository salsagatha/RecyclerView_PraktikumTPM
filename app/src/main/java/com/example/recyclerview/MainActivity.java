package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<CakeModel> cakeModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv_activity);
        rv.setHasFixedSize(true);
        cakeModels.addAll(CakeData.getListData());

        rv.setLayoutManager(new LinearLayoutManager(this));
        CakeAdapter cakeAdapter = new CakeAdapter(this,CakeData.getListData());
        rv.setAdapter(cakeAdapter);
    }
}
