package net.maiatoday.hellointentmatcher

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.TypeSafeMatcher
import org.junit.Test

/**
 * Created by maia on 2017/12/02.
 */
class ContrivedParamsTest {

    @Test
    fun paramsTest() {
        val testee = ContrivedParams("ttt", 3, "ggg")
        assertThat(testee, hasStarCount(3))
        assertThat(testee, hasTitle("ttt"))
        assertThat(testee, hasColour("ggg"))
        val expected = ContrivedParams("ttt", 3, "ggg")
        assertThat(testee, `is`(expected))
        assertThat(testee, equalTo(expected))
    }
}

private fun hasStarCount(i: Int): Matcher<ContrivedParams> {
    return object : TypeSafeMatcher<ContrivedParams>() {
        override fun describeTo(description: Description) {
            description.appendText("starCount should return ").appendValue(i)
        }

        override fun describeMismatchSafely(item: ContrivedParams, mismatchDescription: Description) {
            mismatchDescription.appendText(" was ").appendValue(item.starCount)
        }

        override fun matchesSafely(item: ContrivedParams): Boolean {
            return i == item.starCount
        }
    }
}

private fun hasTitle(t: String): Matcher<ContrivedParams> {
    return object : TypeSafeMatcher<ContrivedParams>() {
        override fun describeTo(description: Description) {
            description.appendText("getNumber should return ").appendValue(t)
        }

        override fun describeMismatchSafely(item: ContrivedParams, mismatchDescription: Description) {
            mismatchDescription.appendText(" was ").appendValue(item.title)
        }

        override fun matchesSafely(item: ContrivedParams): Boolean {
            return t == item.title
        }
    }
}

private fun hasColour(t: String): Matcher<ContrivedParams> {
    return object : TypeSafeMatcher<ContrivedParams>() {
        override fun describeTo(description: Description) {
            description.appendText("getNumber should return ").appendValue(t)
        }

        override fun describeMismatchSafely(item: ContrivedParams, mismatchDescription: Description) {
            mismatchDescription.appendText(" was ").appendValue(item.colour)
        }

        override fun matchesSafely(item: ContrivedParams): Boolean {
            return t == item.colour
        }
    }
}