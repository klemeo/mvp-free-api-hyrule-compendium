package ru.android.hyrulecompendiummvp.ui.utils

import android.content.Context
import android.util.DisplayMetrics

fun Int.dp(context: Context?): Int =
    context?.let {
        this * (context.resources.displayMetrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)
    }?.toInt() ?: 0