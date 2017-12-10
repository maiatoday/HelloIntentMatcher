package net.maiatoday.hellointentmatcher

import android.widget.SeekBar
import android.support.test.espresso.util.HumanReadables
import android.support.test.espresso.PerformException
import android.support.test.espresso.action.CoordinatesProvider
import android.support.test.espresso.action.Press
import android.support.test.espresso.action.GeneralSwipeAction
import android.support.test.espresso.action.ViewActions.actionWithAssertions
import android.support.test.espresso.ViewAction
import android.support.test.espresso.action.Swipe
import android.view.View


/**
 * Created by maia on 2017/12/10.
 */
fun scrubSeekBarAction(progress: Int): ViewAction {
    return actionWithAssertions(GeneralSwipeAction(
            Swipe.SLOW,
            SeekBarThumbCoordinatesProvider(0),
            SeekBarThumbCoordinatesProvider(progress),
            Press.PINPOINT))
}

private class SeekBarThumbCoordinatesProvider(internal var mProgress: Int) : CoordinatesProvider {

    private fun getVisibleLeftTop(view: View): FloatArray {
        val xy = IntArray(2)
        view.getLocationOnScreen(xy)
        return floatArrayOf(xy[0].toFloat(), xy[1].toFloat())
    }

    override fun calculateCoordinates(view: View): FloatArray {
        if (view !is SeekBar) {
            throw PerformException.Builder()
                    .withViewDescription(HumanReadables.describe(view))
                    .withCause(RuntimeException(String.format("SeekBar expected"))).build()
        }
        val width = view.width - view.paddingLeft - view.paddingRight
        val progress = (if (mProgress == 0) view.progress else mProgress).toDouble()
        val xPosition = (view.paddingLeft + width * progress / view.max).toInt()
        val xy = getVisibleLeftTop(view)
        return floatArrayOf(xy[0] + xPosition, xy[1] + 10)
    }
}