package com.example.android.mylibrary;


import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.endpoints.api.quoteEndpoint.model.Quote;
import com.endpoints.api.quoteEndpoint.QuoteEndpoint;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class DisplayAsyncTask extends AsyncTask<Void, Void, List<Quote>>  {
    private static QuoteEndpoint myApiService = null;
    private Context context;

    private OnTaskCompleted mListener;
    private Exception mError = null;

    DisplayAsyncTask(Context context, OnTaskCompleted listener) {
        this.mListener = listener;
        this.context = context;
    }

    @Override
    protected List<Quote> doInBackground(Void... params) {
        if(myApiService == null) {  // Only do this once
            QuoteEndpoint.Builder builder = new QuoteEndpoint.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.listQuote().execute().getItems();
        } catch (IOException e) {
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    protected void onPostExecute(List<Quote> result) {
        for (Quote q : result) {
            Toast.makeText(context, q.getWhat(), Toast.LENGTH_LONG).show();
        }
        // For testing purposes
        String s = result.toString();
        mListener.onTaskCompleted(s);
    }

    @Override
    protected void onCancelled(){

    }
}
