package com.example.adelin.ledspad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.IOException;

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
        try {
            MainActivity.btSocket.getOutputStream().write("s\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finish();
    }

    public void goToMain(View view) {
        try {
            MainActivity.btSocket.getOutputStream().write("q\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setResult(1);
        finish();
    }


}
