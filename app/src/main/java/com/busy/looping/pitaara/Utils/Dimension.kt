package com.busy.looping.pitaara.Utils

import android.content.res.Resources.getSystem

class Dimension {
    val Int.dp: Int get() = (this / getSystem().displayMetrics.density).toInt()

    val Int.px: Int get() = (this * getSystem().displayMetrics.density).toInt()

}