package com.example.adelin.ledspad;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Adelin on 28/04/2017.
 */

public class SudokuNum extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sudoku_num);
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


    public void openSudoku(View view) {
        SudokuNum.this.finish();
    }

    public void sendNum() {
        //send num to wall

        //retourner a sudoWin
    }

    public void sendOne(View view) {
        Toast.makeText(getApplicationContext(), "1 sent", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void sendTwo(View view) {
        Toast.makeText(getApplicationContext(), "2 sent", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void sendThree(View view) {
        Toast.makeText(getApplicationContext(), "3 sent", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void sendFour(View view) {
        Toast.makeText(getApplicationContext(), "4 sent", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void sendFive(View view) {
        Toast.makeText(getApplicationContext(), "5 sent", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void sendSix(View view) {
        Toast.makeText(getApplicationContext(), "6 sent", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void sendSeven(View view) {
        Toast.makeText(getApplicationContext(), "7 sent", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void sendEight(View view) {
        Toast.makeText(getApplicationContext(), "8 sent", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void sendNine(View view) {
        Toast.makeText(getApplicationContext(), "9 sent", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void sendZero(View view) {
        Toast.makeText(getApplicationContext(), "0 sent", Toast.LENGTH_SHORT).show();
        finish();
    }


    //tentative de chnager la couleur quand on clique

    /*final Button ok_button = (Button) findViewById(R.id.ok_button);
    final Button back_button = (Button) findViewById(R.id.back_button);

ok_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
// TODO Auto-generated method stub
            back_button.setBackgroundColor(Color.CYAN);
        }
    });

back_button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View arg0) {
// TODO Auto-generated method stub
            ok_button.setBackgroundColor(Color.RED);
        }
    };
*/

}
