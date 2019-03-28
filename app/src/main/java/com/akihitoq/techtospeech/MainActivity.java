package com.akihitoq.techtospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{
    private TextToSpeech textToSpeech;
    Button btn_speak;
    EditText txt_input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_speak = (Button) findViewById(R.id.btn_speak);
        txt_input = (EditText) findViewById(R.id.InputTxt);
        textToSpeech = new TextToSpeech(this,this);
        textToSpeech.setLanguage(new Locale("th"));

        btn_speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickSpeak();
            }
        });

    }

    private void clickSpeak(){
        textToSpeech.speak(txt_input.getText(), TextToSpeech.QUEUE_FLUSH,null, UUID.randomUUID().toString());
    }

    @Override
    public void onInit(int status) {

    }
}
