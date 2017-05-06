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


// import bt


// extend actionbar a bt
public class MainActivity extends AppCompatActivity {
    public static BluetoothSocket btSocket;
    BluetoothAdapter bluetoothAdapter;
    BroadcastReceiver bluetoothReceiver;

    boolean activate = false;
    boolean connected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bluetoothAdapter.cancelDiscovery();
        unregisterReceiver(bluetoothReceiver);
        if(activate == true) {
            if (bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.disable();
            }
        }
    }

    /**
     * Called when the user taps the Sudoku button
     */
    public void openSudoku(View view) {

        if(connected == true) {
            try {

                btSocket.getOutputStream().write("1\n".getBytes());
                btSocket.getOutputStream().flush();
                startActivity(new Intent(this, Sudoku.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Il faut se connecter", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * Called when the user taps the Snake button
     */
    public void openSnake(View view) {
        if(connected == true) {
            try {

                btSocket.getOutputStream().write("2\n".getBytes());
                btSocket.getOutputStream().flush();
                startActivity(new Intent(this, Snake.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Il faut se connecter", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Called when the user taps the Space Invaders button
     */
    public void openSpaceInvaders(View view) {

        if(connected == true) {
            try {

                btSocket.getOutputStream().write("2\n".getBytes());
                btSocket.getOutputStream().flush();
                startActivity(new Intent(this, SpaceInvaders.class));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            Toast.makeText(getApplicationContext(), "Il faut se connecter", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("NewApi")
    public void connectToWall(View view) {


        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(), "Pas de Bluetooth", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Bluetooth possible", Toast.LENGTH_SHORT).show();
            if (!bluetoothAdapter.isEnabled()) {
                bluetoothAdapter.enable(); //ajouter message
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
                                Toast.makeText(getApplicationContext(), "Connecté au mur !", Toast.LENGTH_SHORT).show();

                            } catch (IOException e) {
                                Log.e("device", "i messed up ", e);
                            }
                        }
                    }
                }
            };

            IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
            registerReceiver(bluetoothReceiver, filter);
            bluetoothAdapter.startDiscovery();
            Log.i("device", "trolololo je suis nouveau");


        }
    }


}
