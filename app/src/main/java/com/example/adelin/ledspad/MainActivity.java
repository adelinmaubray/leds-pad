package com.example.adelin.ledspad;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;
import java.util.UUID;



public class MainActivity extends AppCompatActivity {

    // Variables pour le Bluetooth
    public static BluetoothSocket btSocket = null;
    BluetoothAdapter bluetoothAdapter = null;
    BroadcastReceiver bluetoothReceiver = null;

    // Variables de choix
    public static boolean wantPause = false;
    boolean activateBluetooth = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Supression des variables Bluetooth
        unregisterReceiver(bluetoothReceiver);
        if(activateBluetooth == true) {
            if (bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.disable();
            }
        }
        try {
            MainActivity.btSocket.getOutputStream().write("s\nq\n".getBytes());
            MainActivity.btSocket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Lancer le Sudoku
    public void openSudoku(View view) {

        if(btSocket == null) {
            Toast.makeText(getApplicationContext(), "Il faut se connecter", Toast.LENGTH_SHORT).show();
        }
        else{
            try {

                btSocket.getOutputStream().write("1\n".getBytes());
                btSocket.getOutputStream().flush();
                wantPause = false;
                startActivity(new Intent(this, Sudoku.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Ouvrir le Snake
    public void openSnake(View view) {
        if(btSocket == null) {
            Toast.makeText(getApplicationContext(), "Il faut se connecter", Toast.LENGTH_SHORT).show();
        }
        else{
            try {
                btSocket.getOutputStream().write("2\n".getBytes());
                btSocket.getOutputStream().flush();
                wantPause = false;
                startActivity(new Intent(this, Snake.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // Ouvrir Space Invaders
    public void openSpaceInvaders(View view) {

        if(btSocket == null) {
            Toast.makeText(getApplicationContext(), "Il faut se connecter", Toast.LENGTH_SHORT).show();
        }
        else{
            try {

                btSocket.getOutputStream().write("3\n".getBytes());
                btSocket.getOutputStream().flush();
                wantPause = false;
                startActivity(new Intent(this, SpaceInvaders.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // Connexion Bluetooth
    @SuppressLint("NewApi")
    public void connectToWall(View view) {

        // Réinitialisation des variables
        if(bluetoothReceiver != null){
            bluetoothReceiver = null;
        }

        if(bluetoothAdapter != null){
            bluetoothAdapter = null;
        }


        // Y a-t-il un Bluetooth compatible ?
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(), "Pas de Bluetooth", Toast.LENGTH_SHORT).show();
        }

        else {
            Toast.makeText(getApplicationContext(), "Connexion...", Toast.LENGTH_SHORT).show();
            // Si le Bluetooth est éteint, on l'allume
            if (!bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.enable();
                activateBluetooth = true;
            }

            // Création du BroadcastReceiver
            bluetoothReceiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    Log.i("action", "C'est parti !" + action);
                    if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                        // Parcourt de la liste de device détectable
                        BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                        Log.i("device", "new device" + device.getName());
                        if ("loutrepi".equals(device.getName())) { // à modifier en fonction du server
                            bluetoothAdapter.cancelDiscovery();
                            try {
                                Log.i("device", "trying connect to " + device.getName());
                                // Création du Socket
                                btSocket = device.createInsecureRfcommSocketToServiceRecord(UUID.fromString("94f39d29-7d6d-437d-973b-fba39e49d4ee")); // à modifier en fonction du server
                                // Connexion
                                btSocket.connect();
                                Log.i("device", "connected to " + device.getName());
                                if(btSocket != null) {
                                    Log.i("device", "OUIIII");
                                    Toast.makeText(getApplicationContext(), "Connecté à l'écran !", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    Log.i("device", "NOOOON");
                                    Toast.makeText(getApplicationContext(), "Connexion échouée", Toast.LENGTH_SHORT).show();
                                }

                            } catch (IOException e) {
                                Log.e("device", "i messed up ", e);
                                Toast.makeText(getApplicationContext(), "Connexion échouée", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                }
            };


            IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
            registerReceiver(bluetoothReceiver, filter);
            // Activation de le Recherche
            bluetoothAdapter.startDiscovery();
            Log.i("start","Begining search");

        }
    }


}
