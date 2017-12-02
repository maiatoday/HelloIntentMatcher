package net.maiatoday.hellointentmatcher

import android.os.Parcel
import android.os.Parcelable

/**
 * Contrived parcelable pojo that can be passed to an activity
 * Created by maia on 2017/12/02.
 */
data class ContrivedParams(val title:String="HelloWorld", val starCount:Int=0, val colour:String="#ffffff") : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readInt(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeInt(starCount)
        parcel.writeString(colour)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ContrivedParams> {
        override fun createFromParcel(parcel: Parcel): ContrivedParams {
            return ContrivedParams(parcel)
        }

        override fun newArray(size: Int): Array<ContrivedParams?> {
            return arrayOfNulls(size)
        }
    }
}

