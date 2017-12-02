package net.maiatoday.hellointentmatcher

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

/**
 * Created by maia on 2017/12/02.
 */
fun hasStarCount(i: Int): Matcher<ContrivedParams> {
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

fun hasTitle(t: String): Matcher<ContrivedParams> {
    return object : TypeSafeMatcher<ContrivedParams>() {
        override fun describeTo(description: Description) {
            description.appendText("title should return ").appendValue(t)
        }

        override fun describeMismatchSafely(item: ContrivedParams, mismatchDescription: Description) {
            mismatchDescription.appendText(" was ").appendValue(item.title)
        }

        override fun matchesSafely(item: ContrivedParams): Boolean {
            return t == item.title
        }
    }
}

fun hasColour(t: String): Matcher<ContrivedParams> {
    return object : TypeSafeMatcher<ContrivedParams>() {
        override fun describeTo(description: Description) {
            description.appendText("colour should return ").appendValue(t)
        }

        override fun describeMismatchSafely(item: ContrivedParams, mismatchDescription: Description) {
            mismatchDescription.appendText(" was ").appendValue(item.colour)
        }

        override fun matchesSafely(item: ContrivedParams): Boolean {
            return t == item.colour
        }
    }
}