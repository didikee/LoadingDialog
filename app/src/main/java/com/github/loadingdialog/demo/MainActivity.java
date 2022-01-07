package com.github.loadingdialog.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.loadingdialog.LoadingDialog;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private LoadingDialog loadingDialog;
    private Button btBasic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btBasic = findViewById(R.id.basic);
        btBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNormalDialog();

            }
        });
    }

    private void showNormalDialog() {
        loadingDialog = new LoadingDialog(MainActivity.this);
        loadingDialog.show();

        updateMessage(3000,"这是一条比较短的信息。");
        updateMessage(6000,"这是一条比较长长长长长长长长长长长的信息。");


    }

    private void updateMessage(long delay,String text){
        btBasic.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingDialog.setMessage(text);
            }
        },delay);
    }
}