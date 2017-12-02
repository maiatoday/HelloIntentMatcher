package net.maiatoday.hellointentmatcher

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
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