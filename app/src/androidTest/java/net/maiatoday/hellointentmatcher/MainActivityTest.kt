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
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Created by maia on 2017/12/02.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var rule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val expectedParams = ContrivedParams("Hello World", 3, "#00b0ff")
        onView(withId(R.id.textTitle)).perform(click())
        onView(withId(R.id.textTitle)).perform(replaceText("Hello World"), closeSoftKeyboard())

        pressBack()
        onView(withId(R.id.rbBlue)).perform(click())
        onView(withId(R.id.fab)).perform(click())
        intended(hasComponent(StarActivity::class.java.getName()))
        intended(hasExtras(
                hasEntry(StarActivity.EXTRA_PARAMS, allOf(IsInstanceOf(ContrivedParams::class.java),
                        equalTo(expectedParams)))))
    }
}

