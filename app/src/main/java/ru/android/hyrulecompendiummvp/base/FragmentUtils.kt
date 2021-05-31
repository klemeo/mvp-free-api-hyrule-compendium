package ru.android.hyrulecompendiummvp.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

fun Fragment.showSoftwareKeyboard(view: View) = activity?.showKeyboard(view)

fun Fragment.hideSoftwareKeyboard() = activity?.hideSoftwareKeyboard()

fun Fragment.hideSoftwareKeyboard(delay: Long = 300L, action: (() -> Unit)? = null) {
    hideSoftwareKeyboard()

    action?.let { view?.postDelayed(it, delay) }
}

inline fun <T : Fragment> T.args(builder: Bundle.() -> Unit): T {
    arguments = arguments ?: Bundle()
        .apply(builder)
    return this
}