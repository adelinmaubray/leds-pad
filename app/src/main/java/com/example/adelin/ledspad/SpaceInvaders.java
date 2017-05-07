package com.example.adelin.ledspad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.IOException;

/**
 * Created by Adelin on 28/04/2017.
 */

public class SpaceInvaders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_invaders);
    }

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onStop() {
        super.onStop();
        try {
            MainActivity.btSocket.getOutputStream().write("s\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            MainActivity.btSocket.getOutputStream().write("s\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1000) {
            if (resultCode == 1) {
                finish();
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void shoot() {
        try {
            MainActivity.btSocket.getOutputStream().write("f\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goLeft() {
        try {
            MainActivity.btSocket.getOutputStream().write("l\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goRight() {
        try {
            MainActivity.btSocket.getOutputStream().write("r\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        try {
            MainActivity.btSocket.getOutputStream().write("s\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
            startActivityForResult(new Intent(this, Pause.class), 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
