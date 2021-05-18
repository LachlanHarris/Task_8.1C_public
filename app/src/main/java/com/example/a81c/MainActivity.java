package com.example.a81c;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button playButton;
    EditText VideoURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        VideoURL = findViewById(R.id.YouTubeURLField);
        playButton = findViewById(R.id.PlayButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String VidID = "";
                String URL = VideoURL.getText().toString();
                //Regex commands to take the video ID from the URL
                String regularExpression = "(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed%\u200C\u200B2F|youtu.be%2F|%2Fv%2F)[^#\\&\\?\\n]*";

                Pattern fullPattern = Pattern.compile(regularExpression);
                Matcher matcher = fullPattern.matcher(URL); //url is youtube url for which you want to extract the id.
                if (matcher.find()) {
                     VidID = matcher.group();
                }

                Intent intent = new Intent(MainActivity.this, PlayerActivity.class);
                intent.putExtra("VidID", VidID);
                startActivity(intent);
            }
        });


    }

}