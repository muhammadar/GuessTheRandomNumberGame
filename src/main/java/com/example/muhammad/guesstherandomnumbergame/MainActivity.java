package com.example.muhammad.guesstherandomnumbergame;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;


public class MainActivity extends ActionBarActivity {

    private int number;//The randomly generated number

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextRandomNumber();
    }

    private void nextRandomNumber() {
        Random randomNumber = new Random();
        number = randomNumber.nextInt(1001);

    }

    public void guessButton_Click(View view) {
        EditText userGuess = (EditText) findViewById(R.id.userGuessEditText);
        if(userGuess.getText().toString().matches(""))//Empty Guess
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Enter Number First", Toast.LENGTH_SHORT);
            toast.show();
        }
        else//Nonempty Guess
        {
            int guessedNumber;//User's guess
            guessedNumber = Integer.parseInt(userGuess.getText().toString());
            if(guessedNumber>number+2)//Higher guess
            {
                Toast toastLarge = Toast.makeText(getApplicationContext(), "You Guessed Higher", Toast.LENGTH_SHORT);
                toastLarge.show();
            }
            else
                if(guessedNumber<number-2)//Lower Guess
                {
                    Toast toastSmall = Toast.makeText(getApplicationContext(), "You Guessed Lower", Toast.LENGTH_SHORT);
                    toastSmall.show();
                }
                else
                    if(guessedNumber==number)//Correct Guess
                    {
                        Toast toastEqual = Toast.makeText(getApplicationContext(), "You Guessed Correctly!", Toast.LENGTH_SHORT);
                        toastEqual.show();
                        nextRandomNumber();
                        userGuess.setText("");
                        Toast toastNewNumber = Toast.makeText(getApplicationContext(), "Guess the New Number", Toast.LENGTH_LONG);
                        toastNewNumber.setGravity(Gravity.TOP,0,1000);
                        toastNewNumber.show();
                    }
                    else//Very Close
                    {
                        Toast toastClose = Toast.makeText(getApplicationContext(), "You Are Very Close", Toast.LENGTH_SHORT);
                        toastClose.show();
                    }
        }

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
