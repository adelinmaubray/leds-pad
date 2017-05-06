package com.example.adelin.ledspad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Adelin on 28/04/2017.
 */

public class Snake extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snake);
        Log.i("romrom", "value:" + MainActivity.btSocket);
        try {

            MainActivity.btSocket.getOutputStream().write("2\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Pause Menu", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Resume", Toast.LENGTH_SHORT).show();
    }

    public void goUp(View view) {
        try {

            MainActivity.btSocket.getOutputStream().write("u\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "Up", Toast.LENGTH_SHORT).show();
    }

    public void goDown(View view) {
        try {

            MainActivity.btSocket.getOutputStream().write("d\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "Down", Toast.LENGTH_SHORT).show();
    }

    public void goLeft(View view) {
        try {

            MainActivity.btSocket.getOutputStream().write("l\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "Left", Toast.LENGTH_SHORT).show();
    }

    public void goRight(View view) {
        try {

            MainActivity.btSocket.getOutputStream().write("r\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(getApplicationContext(), "Right", Toast.LENGTH_SHORT).show();
    }

    public void pause(View view) {
        Toast.makeText(getApplicationContext(), "Pause", Toast.LENGTH_SHORT).show();
        startActivityForResult(new Intent(this, Pause.class), 1000);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1000) {
            if (resultCode == 1) {
                finish();
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


}
