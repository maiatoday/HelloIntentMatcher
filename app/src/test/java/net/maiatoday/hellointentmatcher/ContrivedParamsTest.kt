package net.maiatoday.hellointentmatcher

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Test for model object. Contrived test but it shows the new matchers hasStarCount, hasTitle and hasColour
 * Created by maia on 2017/12/02.
 */
class ContrivedParamsTest {

    @Test
    fun paramsTest() {
        val testee = ContrivedParams("Hello World", 3, "#00b0ff")
        //no hamcrest
        assertTrue(testee.title == "Hello World")
        assertTrue(testee.starCount==3)
        assertTrue(testee.colour == "#00b0ff")
        //hamcrest and custom matchers
        assertThat(testee, hasStarCount(3))
        assertThat(testee, hasTitle("Hello World"))
        assertThat(testee, hasColour("#00b0ff"))
        //hamcrest using pojo matcher
        val expected = ContrivedParams("Hello World", 3, "#00b0ff")
        assertThat(testee, `is`(expected))
        assertThat(testee, equalTo(expected))
    }

}