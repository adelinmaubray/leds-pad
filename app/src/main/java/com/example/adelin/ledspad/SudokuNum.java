package com.example.adelin.ledspad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;

import java.io.IOException;

/**
 * Created by Adelin on 28/04/2017.
 */

public class SudokuNum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sudoku_num);
    }

    @Override
    public void onBackPressed() {
    }

    /*
    @Override
    protected void onStop() {
        Log.i("hello","stop num" + MainActivity.wantPause);
        super.onStop();
        if (MainActivity.wantPause == true) {
            try {
                MainActivity.btSocket.getOutputStream().write("num stop\n".getBytes());
                MainActivity.btSocket.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("hello","resume num" + MainActivity.wantPause);
        if(MainActivity.wantPause == true) {
            try {
                MainActivity.btSocket.getOutputStream().write("num resume\n".getBytes());
                MainActivity.btSocket.getOutputStream().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        MainActivity.wantPause = true;
    }
    */

    public void openSudoku(View view) {
        MainActivity.wantPause = false;
        finish();
    }

    public void sendZero(View view){
        try {
            MainActivity.btSocket.getOutputStream().write("0\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MainActivity.wantPause = false;
        finish();
    }

    public void sendOne(View view) {
        try {
            MainActivity.btSocket.getOutputStream().write("1\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
            MainActivity.wantPause = false;
            finish();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendTwo(View view) {
        try {
            MainActivity.btSocket.getOutputStream().write("2\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
            MainActivity.wantPause = false;
            finish();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendThree(View view) {
        try {
            MainActivity.btSocket.getOutputStream().write("3\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
            MainActivity.wantPause = false;
            finish();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendFour(View view) {
        try {
            MainActivity.btSocket.getOutputStream().write("4\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
            MainActivity.wantPause = false;
            finish();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendFive(View view) {
        try {
            MainActivity.btSocket.getOutputStream().write("5\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
            MainActivity.wantPause = false;
            finish();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendSix(View view) {
        try {
            MainActivity.btSocket.getOutputStream().write("6\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
            MainActivity.wantPause = false;
            finish();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendSeven(View view) {
        try {
            MainActivity.btSocket.getOutputStream().write("7\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
            MainActivity.wantPause = false;
            finish();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendEight(View view) {
        try {
            MainActivity.btSocket.getOutputStream().write("8\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
            MainActivity.wantPause = false;
            finish();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendNine(View view) {
        try {
            MainActivity.btSocket.getOutputStream().write("9\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
            MainActivity.wantPause = false;
            finish();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
