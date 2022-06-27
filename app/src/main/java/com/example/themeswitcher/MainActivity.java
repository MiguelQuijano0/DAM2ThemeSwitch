package com.example.themeswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Spinner spinnerThemes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
        setupSpinnerItemSelection();
    }

    private void setupSpinnerItemSelection() {
        spinnerThemes = (Spinner) findViewById(R.id.spinnThemes);
        spinnerThemes.setSelection(ThemeApplication.posicionactual);
        ThemeApplication.posicionactual = spinnerThemes.getSelectedItemPosition();

        spinnerThemes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (ThemeApplication.posicionactual != position) {
                    Utils.changeToTheme(MainActivity.this, position);
                }
                ThemeApplication.posicionactual = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}