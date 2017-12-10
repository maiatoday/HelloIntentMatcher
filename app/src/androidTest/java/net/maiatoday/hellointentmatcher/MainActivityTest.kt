package net.maiatoday.hellointentmatcher

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.BundleMatchers.hasEntry
import android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent
import android.support.test.espresso.intent.matcher.IntentMatchers.hasExtras
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.runner.AndroidJUnit4
import org.hamcrest.CoreMatchers.*
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Test the main activity
 * Created by maia on 2017/12/02.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var rule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val expectedParams = ContrivedParams("Hello World", 2, "#00b0ff")
        //GIVEN: the activity with title, color and starCount choices made
        onView(withId(R.id.textTitle)).perform(click())
        onView(withId(R.id.textTitle)).perform(replaceText("Hello World"), closeSoftKeyboard())
        onView(withId(R.id.rbBlue)).perform(click())
        onView(withId(R.id.starCountBar)).perform(scrubSeekBarAction(2))

        //WHEN: the fab is clicked
        onView(withId(R.id.fab)).perform(click())

        //THEN: an intent for the StarActivity is launched with intent extra which contains the
        // parameters in the ContrivedParams class that matches the values set on the UI
        intended(allOf(
                hasComponent(StarActivity::class.java.name),
                hasExtras(
                        hasEntry(StarActivity.EXTRA_PARAMS, allOf(isA(ContrivedParams::class.java),
                                equalTo(expectedParams))))))
    }
}

