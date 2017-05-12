package com.example.android.mylibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class JokeActivity extends AppCompatActivity implements OnTaskCompleted{
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_joke);

                new DisplayAsyncTask(this, this).execute();

        }

        @Override
        public void onTaskCompleted(String result) {}
}
