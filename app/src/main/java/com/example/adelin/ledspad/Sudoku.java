package com.example.adelin.ledspad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;

import java.io.IOException;

/**
 * Created by Adelin on 28/04/2017.
 */

public class Sudoku extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sudoku);
    }

    @Override
    public void onBackPressed() {
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (MainActivity.wantPause == true) {
            try {
                MainActivity.btSocket.getOutputStream().write("s\n".getBytes());
                MainActivity.btSocket.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(MainActivity.wantPause == true) {
            try {
                MainActivity.btSocket.getOutputStream().write("s\n".getBytes());
                MainActivity.btSocket.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        MainActivity.wantPause = true;
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

    public void openNumWin(View view) {
        MainActivity.wantPause = false;
        startActivity(new Intent(this, SudokuNum.class));
    }

    public void goUp(View view) {
        try {
            MainActivity.btSocket.getOutputStream().write("u\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goDown(View view) {
        try {
            MainActivity.btSocket.getOutputStream().write("d\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goLeft(View view) {
        try {
            MainActivity.btSocket.getOutputStream().write("l\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goRight(View view) {
        try {
            MainActivity.btSocket.getOutputStream().write("r\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pause(View view) {
        try {
            MainActivity.btSocket.getOutputStream().write("s\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
            MainActivity.wantPause = false;
            startActivityForResult(new Intent(this, Pause.class), 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
