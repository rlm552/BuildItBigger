package com.example.android.mylibrary;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.mock.MockContext;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DisplayAsyncTaskTest {

//    @Test
//    public void testJokeButton() throws Exception {
//        MockContext context = new MockContext();
//        DisplayAsyncTask displayAsyncTask = new DisplayAsyncTask(context, this);
//        displayAsyncTask.execute();
//    }
//
//    @Override
//    public void onTaskCompleted(String result) {
//        //Test I want to run//
//        assertNotNull(result);
//
//        //Example test that should return failed//
//        assertEquals(2, 3);
//    }
}
