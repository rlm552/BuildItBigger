package com.example.android.endpoints9;

import android.content.Context;
import android.os.AsyncTask;

import com.endpoints.api.quoteEndpoint.model.Quote;
import com.endpoints.api.quoteEndpoint.QuoteEndpoint;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

public class InsertTask extends AsyncTask<Quote, Void, Void> {
    private static QuoteEndpoint myApiService = null;
    private Context context;

    public InsertTask(Context context){this.context = context;}
    @Override
    protected Void doInBackground(Quote... quotes){
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
            for (int i = 0; i < quotes.length; i++){
                myApiService.insertQuote(quotes[i]).execute();
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

}


