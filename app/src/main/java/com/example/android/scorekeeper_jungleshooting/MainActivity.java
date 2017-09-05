package com.example.android.scorekeeper_jungleshooting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.scorekeeper_jungleshooting.R.id.hp_playerOne;
import static com.example.android.scorekeeper_jungleshooting.R.id.hp_playerTwo;

public class MainActivity extends AppCompatActivity {

    static final String hpPlayerOne = "hp_playerOne";
    static final String hpPlayerTwo = "hp_playerTwo";
    int hpArnie = 100;
    int hpSly = 100;
    int bazooka = 3;
    int grenade = 5;
    int uranium = grenade * 2;
    int medkit = grenade * 3;
    private ProgressBar progressBar;
    private ProgressBar progressBar2;

    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(hpPlayerOne, hpArnie);
        savedInstanceState.putInt(hpPlayerTwo, hpSly);
        savedInstanceState.putInt("progress1", progressBar.getProgress());
        savedInstanceState.putInt("progress2", progressBar2.getProgress());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(hpSly);
        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        progressBar2.setMax(hpArnie);

        if (savedInstanceState != null) {
            hpArnie = savedInstanceState.getInt(hpPlayerOne);
            hpSly = savedInstanceState.getInt(hpPlayerTwo);
            progressBar.setProgress(savedInstanceState.getInt("progress1"));
            progressBar2.setProgress(savedInstanceState.getInt("progress2"));
        }
        displayHpArnie(hpArnie);
        displayHpSly(hpSly);


    }


    //* This is the value for button1 , decreases Hp with 3 points to player2 .

    public void useBazookaOnSly(View view) {
        hpSly = hpSly - bazooka;
        progressBar.incrementProgressBy(-bazooka);
        if (hpSly < 0) {
            hpSly = 0;
            Toast arnieIsWinner = Toast.makeText(getApplicationContext(), "ARNIE Winns the round !!!", Toast.LENGTH_SHORT);
            arnieIsWinner.show();
        }
        displayHpSly(hpSly);
    }


    //* This is the value for button2 , decrease Hp with 5 points to player2 .

    public void useGrenadeOnSly(View view) {
        hpSly = hpSly - grenade;
        progressBar.incrementProgressBy(-grenade);
        if (hpSly < 0) {
            hpSly = 0;
            Toast arnieIsWinner = Toast.makeText(getApplicationContext(), "ARNIE Winns the round !!!", Toast.LENGTH_SHORT);
            arnieIsWinner.show();
        }
        displayHpSly(hpSly);
    }

    //* This is the value for button3 , decrease Hp with 10 points to player2 and with 5 points to player1

    public void useUraniumOnSly(View view) {
        hpSly = hpSly - uranium;
        hpArnie = hpArnie - grenade;
        progressBar.incrementProgressBy(-uranium);
        progressBar2.incrementProgressBy(-grenade);
        if (hpSly < 0) {
            hpSly = 0;
            Toast arnieIsWinner = Toast.makeText(getApplicationContext(), "ARNIE Winns the round !!!", Toast.LENGTH_SHORT);
            arnieIsWinner.show();
        }
        if (hpArnie < 0) {
            hpArnie = 0;
            Toast slyIsWinner = Toast.makeText(getApplicationContext(), "SLY Winns the round !!!", Toast.LENGTH_SHORT);
            slyIsWinner.show();
        }
        displayHpSly(hpSly);
        displayHpArnie(hpArnie);
    }
    //* This is the value for button 4 , player1 receives 15 Hp points

    public void useMedKitonArnie(View view) {
        hpArnie = hpArnie + medkit;
        progressBar2.incrementProgressBy(medkit);
        if (hpArnie > 100) {
            hpArnie = 100;
            Toast maximumHealth = Toast.makeText(getApplicationContext(), "Maximum health reached !!!", Toast.LENGTH_SHORT);
            maximumHealth.show();
        }
        displayHpArnie(hpArnie);
    }

    //*This is the value for button5 , decrease Hp with 3 points to player1

    public void useBazookaOnArnie(View view) {
        hpArnie = hpArnie - bazooka;
        progressBar2.incrementProgressBy(-bazooka);
        if (hpArnie < 0) {
            hpArnie = 0;
            Toast slyIsWinner = Toast.makeText(getApplicationContext(), "SLY Winns the round !!!", Toast.LENGTH_SHORT);
            slyIsWinner.show();
        }
        displayHpArnie(hpArnie);
    }
    //*This is the value for button 6, decrease Hp with 5 points to player1

    public void useGrenadeOnArnie(View view) {
        hpArnie = hpArnie - grenade;
        progressBar2.incrementProgressBy(-grenade);
        if (hpArnie < 0) {
            hpArnie = 0;
            Toast slyIsWinner = Toast.makeText(getApplicationContext(), "SLY Winns the round !!!", Toast.LENGTH_SHORT);
            slyIsWinner.show();
        }
        displayHpArnie(hpArnie);
    }
    //* This is the value for button 7, decreases Hp with 10 points to player1 and 5 points to player2

    public void useUraniumOnArnie(View view) {
        hpArnie = hpArnie - uranium;
        hpSly = hpSly - grenade;
        progressBar2.incrementProgressBy(-uranium);
        progressBar.incrementProgressBy(-grenade);
        if (hpArnie < 0) {
            hpArnie = 0;
            Toast slyIsWinner = Toast.makeText(getApplicationContext(), "SLY Winns the round !!!", Toast.LENGTH_SHORT);
            slyIsWinner.show();
        }
        if (hpSly < 0) {
            hpSly = 0;
            Toast arnieIsWinner = Toast.makeText(getApplicationContext(), "ARNIE Winns the round !!!", Toast.LENGTH_SHORT);
            arnieIsWinner.show();
        }
        displayHpArnie(hpArnie);
        displayHpSly(hpSly);
    }
    //* This is the value of button8 , adds 15 Hp to player2 ( Sly )

    public void useMedKitOnSly(View view) {
        hpSly = hpSly + medkit;
        progressBar.incrementProgressBy(medkit);
        if (hpSly > 100) {
            hpSly = 100;
            Toast maximumHealth = Toast.makeText(getApplicationContext(), "Maximum health reached !!!", Toast.LENGTH_SHORT);
            maximumHealth.show();
        }
        displayHpSly(hpSly);
    }


    public void resetScore(View view) {
        hpSly = 100;
        hpArnie = 100;
        progressBar.setProgress(hpSly);
        progressBar2.setProgress(hpArnie);
        displayHpArnie(hpArnie);
        displayHpSly(hpSly);
    }


    /**
     * Displays the hitpoints for player one ( Arnie ) .
     */
    private void displayHpArnie(int score) {
        TextView scoreView = (TextView) findViewById(hp_playerOne);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the hitpoints for player two ( Sly ) .
     */
    private void displayHpSly(int score) {
        TextView scoreView = (TextView) findViewById(hp_playerTwo);
        scoreView.setText(String.valueOf(score));
    }

}




