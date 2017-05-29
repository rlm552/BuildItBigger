package com.example.android.endpoints9;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.Jokes;
import com.example.android.mylibrary.JokeActivity;

import com.endpoints.api.quoteEndpoint.model.Quote;
import com.example.Jokes;
import com.example.android.endpoints9.InsertTask;
import com.example.android.endpoints9.R;
import com.example.android.mylibrary.JokeActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Jokes jokes = new Jokes();
        String[] funny = jokes.setJokes();

        Quote[] quotes = new Quote[funny.length];
        for (int i = 0; i < 3; i++){
            quotes[i] = new Quote();
            quotes[i].setWhat(funny[i]);
            quotes[i].setId(32323323L + i);
        }

        new InsertTask(this).execute(quotes);

    }

    public void getJokes(View v) {
        Intent intent = new Intent(this, JokeActivity.class);
        startActivity(intent);
    }
}
