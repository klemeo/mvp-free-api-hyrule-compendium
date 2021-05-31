package ru.android.hyrulecompendiummvp.base

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import org.koin.android.ext.android.inject

abstract class BaseFragment(layoutId: Int) : androidx.fragment.app.Fragment(layoutId) {

    protected val screensManager: ScreensManager by inject()

    protected open fun touchable(): Boolean = true

    protected open fun initView(view: View, savedInstanceState: Bundle?) {
        //.
    }

    protected open fun applyTheme() {
        //.
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(view) {
            if (touchable()) {
                setOnTouchListener { _, _ -> true }
            }
        }

        initView(view, savedInstanceState)

        applyTheme()
    }

}