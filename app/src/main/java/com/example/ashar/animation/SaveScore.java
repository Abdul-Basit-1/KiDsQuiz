package com.example.ashar.animation;

/**
 * Created by abdul basit on 3/8/2016.
 */


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SaveScore extends Activity {
    public static final String sharedName = "sharedPreferenceSave";
    public static final String data = "data";
    public static int Highscore = 0;
    SharedPreferences sharedpreferences;
    EditText enter_name;
    TextView player_name, player_score;
    Button save_button, get_button;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_score);

        enter_name = (EditText) findViewById(R.id.enter_name);
        save_button = (Button) findViewById(R.id.save_button);

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveScore saveScore = new SaveScore();
                String sharedName = "sharedPreferenceSave";
                SharedPreferences shared = getSharedPreferences("sharedPreferenceSave", Context.MODE_PRIVATE);
                String data = enter_name.getText().toString();
                SharedPreferences.Editor editor = shared.edit();
                editor.putString("data", data);
                editor.commit();
                Toast.makeText(SaveScore.this, "Thanks", Toast.LENGTH_SHORT).show();
                saveScore.finish();
                Intent home = new Intent(SaveScore.this, MainActivity.class);
                startActivity(home);

            }
        });

    }

}


