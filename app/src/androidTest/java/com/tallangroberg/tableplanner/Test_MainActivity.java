package com.tallangroberg.tableplanner;

import android.app.Instrumentation;
import android.app.Instrumentation.ActivityResult;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.VisibleForTesting;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class Test_MainActivity {



    private String stringToBetyped;
    private String fullText;

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule =
            new IntentsTestRule<>(MainActivity.class);

    @Before
    public void entersName() {
        stringToBetyped = "Taylor <3 xoxo";
    }

    @Test
    public void check_greetingText() {
        onView(withText("Welcome to the table planning app")).check(matches(withId(R.id.welcome)));
    }


    @Test
    public void enterPlannersName() {
        onView(withId(R.id.input_planner_name))
                .perform(typeText(stringToBetyped));
        String fullGreeting = stringToBetyped;
        onView(withId(R.id.submit_planner_button)).perform(click());
    }

    @Test
    public void sendsName() {
        Intent intent = new Intent();
        onView(withId(R.id.input_planner_name))
                .perform(typeText(stringToBetyped));
        onView(withId(R.id.submit_planner_button)).perform(click());



        intent.putExtra("name", stringToBetyped);

        ActivityResult result = new ActivityResult(DecideTableCount.RESULT_OK, intent);

    }
}