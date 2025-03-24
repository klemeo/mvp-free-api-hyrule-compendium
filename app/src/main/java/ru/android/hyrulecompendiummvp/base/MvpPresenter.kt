package ru.android.hyrulecompendiummvp.base

import androidx.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.lang.ref.WeakReference

abstract class MvpPresenter<V>(view: V) : KoinComponent {

    private val viewRef: WeakReference<V> = WeakReference(view)

    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()
    protected val composer: Composer by inject()
    protected val screensManager: ScreensManager by inject()

    val view: V?
        get() = viewRef.get()

    open fun onCreate() {}

    @CallSuper
    open fun onDestroy() {
        compositeDisposable.dispose()
        viewRef.clear()
    }

    fun closeScreen() {
        screensManager.closeTopScreen()
    }

}