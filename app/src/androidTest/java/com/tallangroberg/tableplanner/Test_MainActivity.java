package com.tallangroberg.tableplanner;

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
        String fullGreeting = "Welcome " + stringToBetyped;
        onView(withId(R.id.submit_planner_button)).perform(click());
        onView(withId(R.id.planner_name)).check(matches(withText(fullGreeting)));

    }
}