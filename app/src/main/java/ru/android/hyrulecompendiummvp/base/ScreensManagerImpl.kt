package ru.android.hyrulecompendiummvp.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import java.lang.ref.WeakReference

class ScreensManagerImpl : ScreensManager {

    private lateinit var mActivityWeakRef: WeakReference<AppCompatActivity>
    private var mScreenContainerId: Int = 0

    fun init(activity: AppCompatActivity, screenContainerId: Int) {
        mActivityWeakRef = WeakReference(activity)
        mScreenContainerId = screenContainerId
    }

    override fun showScreen(screen: Fragment) {
        mActivityWeakRef.get()?.let { activity ->
            activity.hideSoftwareKeyboard(
                delay = 0L
            ) {
                if (activity.supportFragmentManager.isStateSaved) return@hideSoftwareKeyboard

                val currentScreen =
                    activity.supportFragmentManager.findFragmentById(mScreenContainerId)

                if (currentScreen != null && currentScreen::class.java == screen::class.java) return@hideSoftwareKeyboard

                activity
                    .supportFragmentManager
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .add(mScreenContainerId, screen, null)
                    .addToBackStack(null)
                    .commitAllowingStateLoss()
            }
        }
    }

    override fun resetStackAndShowScreen(screen: Fragment) {
        mActivityWeakRef.get()?.let { activity ->
            if (activity.supportFragmentManager.isStateSaved) return@let

            activity.hideSoftwareKeyboard()

            activity.supportFragmentManager
                .popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)

            activity
                .supportFragmentManager
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(mScreenContainerId, screen, null)
                .commitAllowingStateLoss()
        }
    }

    override fun closeTopScreen() {
        mActivityWeakRef.get()?.let { activity ->
            if (activity.supportFragmentManager.isStateSaved) return@let

            activity.hideSoftwareKeyboard()

            activity.supportFragmentManager.findFragmentById(mScreenContainerId)
                ?.let { fragment ->
                    val fmFragment = activity.supportFragmentManager
                    fmFragment.popBackStack()
                    fmFragment.beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                        .remove(fragment)
                        .commit()

                }
        }
    }

    override fun closeUntil(screenClass: Class<*>, inclusive: Boolean, needTransition: Boolean) {
        mActivityWeakRef.get()?.let { activity ->

            if (activity.supportFragmentManager.isStateSaved) return@let

            activity.hideSoftwareKeyboard()

            while (true) {
                val topFragment =
                    activity.supportFragmentManager.findFragmentById(mScreenContainerId) ?: return

                if (topFragment::class.java == screenClass) {

                    if (inclusive) {

                        activity.supportFragmentManager.popBackStack()

                        activity.supportFragmentManager.beginTransaction()
                            .apply {
                                if (needTransition)
                                    setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                            }
                            .remove(topFragment)
                            .commitNow()

                    }

                    return@let

                } else {
                    activity.supportFragmentManager.popBackStack()

                    activity.supportFragmentManager.beginTransaction()
                        .apply {
                            if (needTransition)
                                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                        }
                        .remove(topFragment)
                        .commitNow()
                }
            }
        }
    }
}