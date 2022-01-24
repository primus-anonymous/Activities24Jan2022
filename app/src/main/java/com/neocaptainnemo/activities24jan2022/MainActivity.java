package com.neocaptainnemo.activities24jan2022;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText initialCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_open_lifecycle).setOnClickListener(this);

        findViewById(R.id.btn_open_counter).setOnClickListener(this);

        initialCount = findViewById(R.id.initial_count);

        log("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        log("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        log("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        log("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        log("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        log("onDestroy");
    }

    private void log(String event) {
        Log.d("MainActivityLog", event);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_open_lifecycle:
                Intent lifecycleIntent = new Intent(MainActivity.this, LifecycleActivity.class);
                startActivity(lifecycleIntent);

                break;

            case R.id.btn_open_counter:
                Intent counterIntent = new Intent(MainActivity.this, CounterActivity.class);
                counterIntent.putExtra(CounterActivity.EXTRA_INITIAL_VALUE, Integer.parseInt(initialCount.getText().toString()));
                startActivity(counterIntent);

                break;
        }
    }
}