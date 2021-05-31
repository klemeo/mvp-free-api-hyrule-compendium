package ru.android.hyrulecompendiummvp.base

import android.content.Context
import android.view.inputmethod.InputMethodManager

fun Context.getInputMethodManager() =
    getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
