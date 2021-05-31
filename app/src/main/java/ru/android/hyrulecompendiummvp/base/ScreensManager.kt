package ru.android.hyrulecompendiummvp.base

import androidx.fragment.app.Fragment

interface ScreensManager {

    fun showScreen(screen: Fragment)

    fun resetStackAndShowScreen(screen: Fragment)

    fun closeTopScreen()

    fun closeUntil(screenClass: Class<*>, inclusive: Boolean = false, needTransition: Boolean = true)

}