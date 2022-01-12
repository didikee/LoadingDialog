package com.github.loadingdialog.demo;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RecyclerWithEmptyActivity extends AppCompatActivity {

    private View recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_empty);

        recyclerView = findViewById(R.id.recyclerView);
    }
}
