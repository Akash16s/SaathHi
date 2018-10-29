package com.example.akash.farmersassistant;

import android.app.SearchManager;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class assistance extends AppCompatActivity {
    TextView textresult;
    String spokenText;
    String[] keywords={"hello","namaste","Mausam","weather","card","seeds","help","madad","beach","Dam","Rojgar","Beema","schemes","yojana","namaskar","centers","\0"};
    private static final int SPEECH_REQUEST_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assistance);
        textresult=(TextView) findViewById(R.id.textresult);

    }


    public void listen(View view){
        displaySpeechRecognizer();
    }
    // Create an intent that can start the Speech Recognizer activity
    private void displaySpeechRecognizer() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
// Start the activity, the intent will be populated with the speech text
        startActivityForResult(intent, SPEECH_REQUEST_CODE);
    }
    // This callback is invoked when the Speech Recognizer returns.
// This is where you process the intent and extract the speech text from the intent.
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK) {
            ArrayList<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            spokenText = results.get(0);
           textresult.setText(spokenText);
           findKeywords();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void findKeywords(){
        int i=0;
        while(i<13){
       if(spokenText.contains(keywords[i].toString())){
           break;
       }
       i++;
        }
        execute(i);

    }

    public void execute(int i){
        switch (i){
            case 0: returnGree();
            break;
            case 1:returnGree();
            break;
            case 2:weather();
            break;
            case 3:weather();
            break;
            case 4:khaadseeds(4);
                break;
            case 5:khaadseeds(5);
            break;
            case 6:help();
            break;
            case 7:help();
            break;
            case 9:khaadseeds(9);
            break;
            case 10:help();
            break;
            case 11:help();
            break;
            case 12:scheme();
            break;
            case 13:scheme();
                break;
        }
    }

    public void scheme(){
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, "http://agricoop.nic.in/programmes-schemes-listing");
        startActivity(intent);

    }
    public void returnGree(){
        textresult.setText("Nameste Kaise hain!!");
    }

    public void weather(){
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, "today's Whether");
        startActivity(intent);

    }

    public void khaadseeds(int i){
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, keywords[i]+" sale");
        startActivity(intent);

    }

    public void help(){
        Intent intent=new Intent(this,help.class);
        startActivity(intent);

    }
}