package com.neocaptainnemo.activities24jan2022;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.neocaptainnemo.activities24jan2022.domain.Counter;

public class CounterActivity extends AppCompatActivity {

    public static final String EXTRA_INITIAL_VALUE = "EXTRA_INITIAL_VALUE";
    private static final String ARG_COUNTER = "ARG_COUNTER";
    private Counter counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        if (savedInstanceState == null) {
            int value = getIntent().getIntExtra(EXTRA_INITIAL_VALUE, 0);
            counter = new Counter(value);
        } else {
            counter = savedInstanceState.getParcelable(ARG_COUNTER);
        }

        TextView textCounter = findViewById(R.id.counter);

        textCounter.setText(String.valueOf(counter.getValue()));

        findViewById(R.id.increase).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                counter.increase();

                textCounter.setText(String.valueOf(counter.getValue()));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable(ARG_COUNTER, counter);
    }
}