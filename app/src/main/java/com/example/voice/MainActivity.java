package com.example.voice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int SPEECH_REQUEST_CODE = 0;
    ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (ConstraintLayout)findViewById(R.id.layout);
    }

    public void start(View v){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String text = results.get(0).toLowerCase();
            if(text.contains("black"))
                layout.setBackgroundColor(Color.BLACK);
            else if(text.contains("yellow"))
                layout.setBackgroundColor(Color.YELLOW);
            else if(text.contains("red"))
                layout.setBackgroundColor(Color.RED);
            else if(text.contains("green"))
                layout.setBackgroundColor(Color.GREEN);
            else if(text.contains("magenta"))
                layout.setBackgroundColor(Color.MAGENTA);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
