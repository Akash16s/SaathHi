package com.example.akash.farmersassistant;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FrontPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                AssistActivity();
            }
        }, 3000);
    }

    public void AssistActivity(){
        Intent intent = new Intent(this,Assistant.class);
        startActivity(intent);
        finish();
    }
}
