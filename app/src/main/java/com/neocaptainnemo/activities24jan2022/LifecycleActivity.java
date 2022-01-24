package com.neocaptainnemo.activities24jan2022;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LifecycleActivity extends AppCompatActivity {

    private static final String ARG_COUNT = "ARG_COUNT";

    private int counter = 0;

    private TextView textValue;

    private class ClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.text_value) {
                counter++;

                textValue.setText(String.valueOf(counter));
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lifecycle);

        textValue = findViewById(R.id.text_value);

        textValue.setOnClickListener(new ClickHandler());

        if (savedInstanceState == null) {
            log("onCreate for the first time");
        } else {
            log("onCreate for the next time");

            counter = savedInstanceState.getInt(ARG_COUNT);

            if (counter != 0) {
                textValue.setText(String.valueOf(counter));
            }
        }

        View.OnClickListener closeClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        };

        findViewById(R.id.close).setOnClickListener(closeClick);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        log("onRestoreInstanceState");

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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(ARG_COUNT, counter);

        log("onSaveInstanceState");

    }

    private void log(String event) {
        Log.d("LifecycleActivityLog", event);
    }
}
