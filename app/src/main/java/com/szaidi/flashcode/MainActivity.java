package com.szaidi.flashcode;

import android.app.Activity;
import android.content.Context;
import android.graphics.Camera;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        editText = (EditText) findViewById(R.id.editText);

        Button mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                String letter;
                String morseLetter;

                for (int i = 0; i < text.length(); i++) {
                    letter = text.charAt(i)+ "";
                    morseLetter = convert(letter);

                }
            }
        });




    }

    private String convert(String letter) {
        String convertedMorse = null;

        if(letter.equalsIgnoreCase("a"))
            convertedMorse = ".-";
        if(letter.equalsIgnoreCase("b"))
            convertedMorse = "-...";
        if(letter.equalsIgnoreCase("c"))
            convertedMorse = "-.-.";
        if(letter.equalsIgnoreCase("d"))
            convertedMorse = "-..";
        if(letter.equalsIgnoreCase("e"))
            convertedMorse = ".";
        if(letter.equalsIgnoreCase("f"))
            convertedMorse = "..-.";
        if(letter.equalsIgnoreCase("g"))
            convertedMorse = "--.";
        if(letter.equalsIgnoreCase("h"))
            convertedMorse = "....";
        if(letter.equalsIgnoreCase("i"))
            convertedMorse = "..";
        if(letter.equalsIgnoreCase("j"))
            convertedMorse = ".---";
        if(letter.equalsIgnoreCase("k"))
            convertedMorse = "-.-";
        if(letter.equalsIgnoreCase("l"))
            convertedMorse = ".-..";
        if(letter.equalsIgnoreCase("m"))
            convertedMorse = "--";
        if(letter.equalsIgnoreCase("n"))
            convertedMorse = "-.";
        if(letter.equalsIgnoreCase("o"))
            convertedMorse = "---";
        if(letter.equalsIgnoreCase("p"))
            convertedMorse = ".--.";
        if(letter.equalsIgnoreCase("q"))
            convertedMorse = "--.-";
        if(letter.equalsIgnoreCase("r"))
            convertedMorse = ".-.";
        if(letter.equalsIgnoreCase("s"))
            convertedMorse = "...";
        if(letter.equalsIgnoreCase("t"))
            convertedMorse = "-";
        if(letter.equalsIgnoreCase("u"))
            convertedMorse = "..-";
        if(letter.equalsIgnoreCase("v"))
            convertedMorse = "...-";
        if(letter.equalsIgnoreCase("w"))
            convertedMorse = ".--";
        if(letter.equalsIgnoreCase("x"))
            convertedMorse = "-..-";
        if(letter.equalsIgnoreCase("y"))
            convertedMorse = "-.--";
        if(letter.equalsIgnoreCase("z"))
            convertedMorse = "--..";
        if(letter.equals("1"))
            convertedMorse = ".----";
        if(letter.equals("2"))
            convertedMorse = "..---";
        if(letter.equals("3"))
            convertedMorse = "...--";
        if(letter.equals("4"))
            convertedMorse = "....-";
        if(letter.equals("5"))
            convertedMorse = ".....";
        if(letter.equals("6"))
            convertedMorse = "-....";
        if(letter.equals("7"))
            convertedMorse = "--...";
        if(letter.equals("8"))
            convertedMorse = "---..";
        if(letter.equals("9"))
            convertedMorse = "----.";
        if(letter.equals("0"))
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}