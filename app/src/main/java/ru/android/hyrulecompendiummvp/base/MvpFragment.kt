package ru.android.hyrulecompendiummvp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper

abstract class MvpFragment<P : MvpPresenter<*>> : androidx.fragment.app.Fragment() {

    protected abstract val presenter: P

    protected abstract val layout: Int

    protected open fun touchable(): Boolean = true

    protected open fun initView(view: View, savedInstanceState: Bundle?) {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(layout, container, false)

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(view) {
            if (touchable()) {
                setOnTouchListener { _, _ -> true }
            }
        }

        initView(view, savedInstanceState)

        presenter.onCreate()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        presenter.onDestroy()
    }

}