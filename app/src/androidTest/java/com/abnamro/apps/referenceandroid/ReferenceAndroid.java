package com.abnamro.apps.referenceandroid;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class ReferenceAndroid{

    @Rule
    public ActivityTestRule<MainActivity> mActivity = new ActivityTestRule<>(MainActivity.class);

    @Test()
    //Verify the title of the page which is "ReferenceAndroid"

    public void verifyTitle(){
    onView(withText("ReferenceAndroid")).check(matches(isDisplayed()));
    }

    @Test()
    //Verify the content of the page which is Hello World!

    public void verifyContent() {
    onView(withText("Hello World!")).check(matches(isDisplayed()));
    }

    @Test()
    //Verify the More options icon(Three dots) on top right
    //Verify Settings icon upon clicking More options
    //Verify the Settings is enabled

    public void verifySettings() {
    onView(withContentDescription("More options")).check(matches(isDisplayed())).perform(click());
    onView(withText("Settings")).check(matches(isEnabled()));
    }
    @Test()
    //Verify the floating button on bottom right
    //Verify the snackbar displayed on bottom upon clicking the floating button

    public void verifyFloatButton() throws InterruptedException {
    onView(withId(R.id.fab)).check(matches(isDisplayed())).perform(click());
    onView(withId(R.id.snackbar_text)).check(matches(withText("Replace with your own action")));

    //Verify snackbar gets disappeared from bottom of the app after few seconds

    Thread.sleep(5000);
    onView(withId(R.id.snackbar_text)).check(doesNotExist());
    }

}
