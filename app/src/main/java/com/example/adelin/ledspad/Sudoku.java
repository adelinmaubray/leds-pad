package com.example.adelin.ledspad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Adelin on 28/04/2017.
 */

public class Sudoku extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku);
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


/*    public void goLeft(View view) {
        String message = "left";
        TextView textView = (TextView) findViewById(R.id.displayTest);
        textView.setText(message);
    }
*/

    public void openNumWin(View view) {
        startActivity(new Intent(this, SudokuNum.class));
    }

    public void goUp(View view) {
        Toast.makeText(getApplicationContext(), "Up", Toast.LENGTH_SHORT).show();
    }

    public void goDown(View view) {
        Toast.makeText(getApplicationContext(), "Down", Toast.LENGTH_SHORT).show();
    }

    public void goLeft(View view) {
        Toast.makeText(getApplicationContext(), "Left", Toast.LENGTH_SHORT).show();
    }

    public void goRight(View view) {
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
