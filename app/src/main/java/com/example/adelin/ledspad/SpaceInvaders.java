package com.example.adelin.ledspad;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;

import java.io.IOException;

/**
 * Created by Adelin on 28/04/2017.
 */

public class SpaceInvaders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_space_invaders);
    }

    @Override
    public void onBackPressed() {
    }

    // On fait pause quand l'activité d'arrête
    // Mais pas si on passe dans un autre activité (pour ne pas envoyer un signal pour rien
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

    // On arrête la pause quand l'activité redémarre
    // Mais pas si c'est la première fois qu'elle s'affiche
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

    //Réponse à l'activité for startActivityForResult
    // On finish() l'activité quand le Menu Pause s'arrête
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1000) {
            if (resultCode == 1) {
                finish();
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void shoot(View view) {
        try {
            MainActivity.btSocket.getOutputStream().write("f\n".getBytes());
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

    //Afficher Menu Pause
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
