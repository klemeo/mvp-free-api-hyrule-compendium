package ru.android.hyrulecompendiummvp.base

import android.app.Activity
import android.view.View
import android.widget.Toast

fun Activity.hideSoftwareKeyboard(delay: Long = 300L, action: (() -> Unit)? = null) {
    val view = findViewById<View>(android.R.id.content)

    getInputMethodManager()
        .hideSoftInputFromWindow(view.windowToken, 0)

    action?.let { view?.postDelayed(it, delay) }
}

fun Activity.showKeyboard(view: View) =
    getInputMethodManager().showSoftInput(view, 0)

fun Activity.toast(text: String, length: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, text, length).show()
