package net.maiatoday.hellointentmatcher


import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Contrived parcelable pojo that can be passed to an activity
 * Created by maia on 2017/12/02.
 */
@SuppressLint("ParcelCreator") //https://youtrack.jetbrains.com/oauth?state=%2Fissue%2FKT-19300
@Parcelize
data class ContrivedParams(val title:String="HelloWorld", val starCount:Int=0, val colour:String="#ffffff") : Parcelable

