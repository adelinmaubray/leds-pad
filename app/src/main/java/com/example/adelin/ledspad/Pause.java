package com.example.adelin.ledspad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Adelin on 29/04/2017.
 */

public class Pause extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pause);
    }

    @Override
    public void onBackPressed() {

    }

    public void back(View view) {
        finish();
    }

    public void goToMain(View view) {
        Toast.makeText(getApplicationContext(), "Retour menu", Toast.LENGTH_SHORT).show();
        setResult(1);
        this.finish();
    }


}
