package com.tallangroberg.tableplanner;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.ContentView;
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

import static android.content.Intent.EXTRA_TEXT;
import static org.junit.Assert.*;

    @RunWith(AndroidJUnit4.class)
    @LargeTest
    public class Test_DecideTableCount {
        private String planner_name;


        @Before
        public void entersName() {
            planner_name = "Taylor <3 xoxo";
        }



        @Rule
        public ActivityScenarioRule<DecideTableCount> activityRule =
                new ActivityScenarioRule<>(DecideTableCount.class);
        @Test
        public void intent_recieved() {

           onView(withId(R.id.planner))
                   .check(matches(withText("")));

        }

        @Test
        public void asks_how_many_tables() {
            onView(withId(R.id.how_many_tables))
                    .check(matches(withText("How many tables will be at your dinner party")));
        }


    }