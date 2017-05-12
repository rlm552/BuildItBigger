package com.example.android.mylibrary;
import android.support.test.runner.AndroidJUnit4;
import android.test.mock.MockContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DisplayAsyncTaskTest implements OnTaskCompleted{
    @Test
    public void testJokeButton() throws Exception {
        MockContext context = new MockContext();
        DisplayAsyncTask displayAsyncTask = new DisplayAsyncTask(context, this);
        displayAsyncTask.execute();
    }

    @Override
    public void onTaskCompleted(String result) {
        //Test I want to run//
        assertNotNull(result);

        //Example test that should return failed//
        assertEquals(2, 3);
    }
}
