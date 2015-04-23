package com.szaidi.flashcode;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import java.lang.Thread;
import java.util.jar.JarEntry;

public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    EditText editText;
    private Camera camera;
    private boolean isFlashOn = false;

    String versionName = BuildConfig.VERSION_NAME;

    protected void onStop() {
        super.onStop();
        if (camera != null) {
            camera.release();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage("FlashCode lets you easily convert any message into morse code. Simply type in your message and tap the button! It will convert your message to morse code and transmit via your flashlight!")
                .setPositiveButton(R.string.dialogClose, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        editText = (EditText) findViewById(R.id.editText);
        Button mButton = (Button) findViewById(R.id.button);
        Context context = this;
        PackageManager pm = context.getPackageManager();

        if (!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            Log.e("err", "Device has no camera!");
            return;
        }

        camera = Camera.open();
        final Parameters p = camera.getParameters();

        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                String letter;
                String morseLetter;

                for (int i = 0; i < text.length(); i++) {
                    letter = text.charAt(i) + "";
                    morseLetter = convert(letter);

                    Toast.makeText(getApplicationContext(), morseLetter, Toast.LENGTH_SHORT).show();

                    for (int j = 0; j < morseLetter.length(); j++) {
                        if (morseLetter.charAt(j) == '-') {
                            if (!isFlashOn) {
                                p.setFlashMode(Parameters.FLASH_MODE_TORCH);
                                camera.setParameters(p);
                                camera.startPreview();
                                isFlashOn = true;
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    // handle the exception...
                                    // For example consider calling Thread.currentThread().interrupt(); here.
                                    Thread.currentThread().interrupt();
                                }
                                p.setFlashMode(Parameters.FLASH_MODE_OFF);
                                camera.setParameters(p);
                                camera.stopPreview();
                                isFlashOn = false;
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    // handle the exception...
                                    // For example consider calling Thread.currentThread().interrupt(); here.
                                    Thread.currentThread().interrupt();
                                }
                            }
                        } else if (morseLetter.charAt(j) == '.') {
                            if (!isFlashOn) {
                                p.setFlashMode(Parameters.FLASH_MODE_TORCH);
                                camera.setParameters(p);
                                camera.startPreview();
                                isFlashOn = true;
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    // handle the exception...
                                    // For example consider calling Thread.currentThread().interrupt(); here.
                                    Thread.currentThread().interrupt();
                                }
                                p.setFlashMode(Parameters.FLASH_MODE_OFF);
                                camera.setParameters(p);
                                camera.stopPreview();
                                isFlashOn = false;
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                    // handle the exception...
                                    // For example consider calling Thread.currentThread().interrupt(); here.
                                    Thread.currentThread().interrupt();
                                }
                            }
                        }

                    }

                }
            }
        });


    }

    private String convert(String letter) {
        String convertedMorse = null;

        if (letter.equalsIgnoreCase("a"))
            convertedMorse = ".-";
        if (letter.equalsIgnoreCase("b"))
            convertedMorse = "-...";
        if (letter.equalsIgnoreCase("c"))
            convertedMorse = "-.-.";
        if (letter.equalsIgnoreCase("d"))
            convertedMorse = "-..";
        if (letter.equalsIgnoreCase("e"))
            convertedMorse = ".";
        if (letter.equalsIgnoreCase("f"))
            convertedMorse = "..-.";
        if (letter.equalsIgnoreCase("g"))
            convertedMorse = "--.";
        if (letter.equalsIgnoreCase("h"))
            convertedMorse = "....";
        if (letter.equalsIgnoreCase("i"))
            convertedMorse = "..";
        if (letter.equalsIgnoreCase("j"))
            convertedMorse = ".---";
        if (letter.equalsIgnoreCase("k"))
            convertedMorse = "-.-";
        if (letter.equalsIgnoreCase("l"))
            convertedMorse = ".-..";
        if (letter.equalsIgnoreCase("m"))
            convertedMorse = "--";
        if (letter.equalsIgnoreCase("n"))
            convertedMorse = "-.";
        if (letter.equalsIgnoreCase("o"))
            convertedMorse = "---";
        if (letter.equalsIgnoreCase("p"))
            convertedMorse = ".--.";
        if (letter.equalsIgnoreCase("q"))
            convertedMorse = "--.-";
        if (letter.equalsIgnoreCase("r"))
            convertedMorse = ".-.";
        if (letter.equalsIgnoreCase("s"))
            convertedMorse = "...";
        if (letter.equalsIgnoreCase("t"))
            convertedMorse = "-";
        if (letter.equalsIgnoreCase("u"))
            convertedMorse = "..-";
        if (letter.equalsIgnoreCase("v"))
            convertedMorse = "...-";
        if (letter.equalsIgnoreCase("w"))
            convertedMorse = ".--";
        if (letter.equalsIgnoreCase("x"))
            convertedMorse = "-..-";
        if (letter.equalsIgnoreCase("y"))
            convertedMorse = "-.--";
        if (letter.equalsIgnoreCase("z"))
            convertedMorse = "--..";
        if (letter.equals("1"))
            convertedMorse = ".----";
        if (letter.equals("2"))
            convertedMorse = "..---";
        if (letter.equals("3"))
            convertedMorse = "...--";
        if (letter.equals("4"))
            convertedMorse = "....-";
        if (letter.equals("5"))
            convertedMorse = ".....";
        if (letter.equals("6"))
            convertedMorse = "-....";
        if (letter.equals("7"))
            convertedMorse = "--...";
        if (letter.equals("8"))
            convertedMorse = "---..";
        if (letter.equals("9"))
            convertedMorse = "----.";
        if (letter.equals("0"))
            convertedMorse = "-----";

        return convertedMorse;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            new AlertDialog.Builder(this)
                    .setTitle("Flash Code v" + versionName)
                    .setMessage("Flash Code is a free and open source app. Copyright 2015 Sajjad Zaidi. All Rights Reserved.")
                    .setPositiveButton(R.string.dialogClose, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
