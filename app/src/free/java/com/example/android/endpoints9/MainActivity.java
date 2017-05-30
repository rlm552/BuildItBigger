package com.example.android.endpoints9;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.endpoints.api.quoteEndpoint.model.Quote;
import com.example.Jokes;
import com.example.android.endpoints9.InsertTask;
import com.example.android.endpoints9.R;
import com.example.android.mylibrary.JokeActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        long idStart = 32323323L;
        String APP_ID = "ca-app-pub-3940256099942544~3347511713";

        Jokes jokes = new Jokes();
        String[] funny = jokes.setJokes();


        Quote[] quotes = new Quote[funny.length];

        for (int i = 0; i < 3; i++){
            quotes[i] = new Quote();
            quotes[i].setWhat(funny[i]);
            quotes[i].setId(idStart + i);
        }

        new InsertTask(this).execute(quotes);
        MobileAds.initialize(getApplicationContext(),
                APP_ID);
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    public void getJokes(View v) {
        Intent intent = new Intent(this, JokeActivity.class);
        startActivity(intent);
    }
}
