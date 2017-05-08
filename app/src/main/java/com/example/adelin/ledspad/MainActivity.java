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
    public static BluetoothSocket btSocket = null;
    BluetoothAdapter bluetoothAdapter;
    BroadcastReceiver bluetoothReceiver;

    boolean activate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(bluetoothReceiver);
        if(activate == true) {
            if (bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.disable();
            }
        }
    }


    public void openSudoku(View view) {

        if(btSocket == null) {
            Toast.makeText(getApplicationContext(), "Il faut se connecter", Toast.LENGTH_SHORT).show();
        }
        else{
            try {

                btSocket.getOutputStream().write("1\n".getBytes());
                btSocket.getOutputStream().flush();
                startActivity(new Intent(this, Sudoku.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void openSnake(View view) {
        if(btSocket == null) {
            Toast.makeText(getApplicationContext(), "Il faut se connecter", Toast.LENGTH_SHORT).show();
        }
        else{
            try {
                btSocket.getOutputStream().write("2\n".getBytes());
                btSocket.getOutputStream().flush();
                startActivity(new Intent(this, Snake.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void openSpaceInvaders(View view) {

        if(btSocket == null) {
            Toast.makeText(getApplicationContext(), "Il faut se connecter", Toast.LENGTH_SHORT).show();
        }
        else{
            try {

                btSocket.getOutputStream().write("3\n".getBytes());
                btSocket.getOutputStream().flush();
                startActivity(new Intent(this, SpaceInvaders.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @SuppressLint("NewApi")
    public void connectToWall(View view) {

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(), "Pas de Bluetooth", Toast.LENGTH_SHORT).show();
        }

        else {
            Toast.makeText(getApplicationContext(), "Connexion...", Toast.LENGTH_SHORT).show();
            if (!bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.enable();
                activate = true;
            }

            bluetoothReceiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    String action = intent.getAction();
                    Log.i("device", "new action" + action);
                    if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                        BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                        Log.i("device", "new device" + device.getName());
                        if ("loutrepi".equals(device.getName())) {
                            bluetoothAdapter.cancelDiscovery();
                            try {
                                Log.i("device", "trying connect to " + device.getName());
                                btSocket = device.createInsecureRfcommSocketToServiceRecord(UUID.fromString("94f39d29-7d6d-437d-973b-fba39e49d4ee"));
                                btSocket.connect();
                                Log.i("device", "connected to " + device.getName());
                                Toast.makeText(getApplicationContext(), "Connecté à l'écran !", Toast.LENGTH_SHORT).show();

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
            bluetoothAdapter.startDiscovery();

        }
    }


}
