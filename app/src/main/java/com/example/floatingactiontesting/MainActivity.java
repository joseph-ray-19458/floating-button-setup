package com.example.floatingactiontesting;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
public class MainActivity extends AppCompatActivity {

    private boolean isExtended = false;
    private FloatingActionButton mainFAB;
    private FloatingActionButton createTripFAB;
    private FloatingActionButton startTripFAB;
    private View extendedOptions;
    private View mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout =findViewById(R.id.activity_main_layout);
        mainFAB = findViewById(R.id.fab_main);
        createTripFAB = findViewById(R.id.fab_create_trip);
        startTripFAB = findViewById(R.id.fab_start_trip);
        extendedOptions = findViewById(R.id.extended_options);

        mainFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleExtendedOptions();
            }
        });

        createTripFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the "create trip" action
                displayToast("Create Trip clicked");
                toggleExtendedOptions();
            }
        });

        startTripFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the "start trip" action
                displayToast("Start Trip clicked");
                toggleExtendedOptions();
            }
        });

        extendedOptions.setVisibility(View.GONE);
        // Set up touch listener for the main ConstraintLayout
        mainLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (isExtended && event.getAction() == MotionEvent.ACTION_DOWN) {
                    toggleExtendedOptions();
                }
                boolean b = false;
                return b;
            }
        });
    }

    private void toggleExtendedOptions() {
        if (isExtended) {
            extendedOptions.setVisibility(View.GONE);
            mainLayout.setAlpha(1f);
            mainFAB.setImageResource(R.drawable.baseline_add_24);


        } else {
            extendedOptions.setVisibility(View.VISIBLE);
            mainFAB.setImageResource(R.drawable.baseline_close_24);
            mainLayout.setAlpha(0.2f);
        }
        isExtended = !isExtended;
    }


    private void displayToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
