package ru.android.hyrulecompendiummvp.base

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Publisher

object SchedulerComposerFactory {

    fun android(): Composer = create(Schedulers.io(), AndroidSchedulers.mainThread())

    fun create(subscribeOn: Scheduler, observeOn: Scheduler): Composer =
        SchedulerComposerImpl(subscribeOn, observeOn)

}

private class SchedulerComposerImpl(
    private val subscribeOn: Scheduler,
    private val observeOn: Scheduler
) : Composer {

    override fun <T> observable(): ObservableTransformer<T, T> =
        ObservableApplyScheduler(subscribeOn, observeOn)

    override fun completable(): CompletableTransformer =
        CompletableApplyScheduler(subscribeOn, observeOn)

    override fun <T> single(): SingleTransformer<T, T> =
        SingleApplyScheduler(subscribeOn, observeOn)

    override fun <T> maybe(): MaybeTransformer<T, T> =
        MaybeApplyScheduler(subscribeOn, observeOn)

    override fun <T> flowable(): FlowableTransformer<T, T> =
        FlowableApplyScheduler(subscribeOn, observeOn)

}

private class ObservableApplyScheduler<T>(
    private val subscribeOn: Scheduler,
    private val observeOn: Scheduler
) : ObservableTransformer<T, T> {
    override fun apply(upstream: Observable<T>): ObservableSource<T> =
        upstream.subscribeOn(subscribeOn)
            .observeOn(observeOn)
}

private class CompletableApplyScheduler(
    private val subscribeOn: Scheduler,
    private val observeOn: Scheduler
) : CompletableTransformer {
    override fun apply(upstream: Completable): CompletableSource =
        upstream.subscribeOn(subscribeOn)
            .observeOn(observeOn)
}

private class SingleApplyScheduler<T>(
    private val subscribeOn: Scheduler,
    private val observeOn: Scheduler
) : SingleTransformer<T, T> {
    override fun apply(upstream: Single<T>): SingleSource<T> =
        upstream.subscribeOn(subscribeOn)
            .observeOn(observeOn)
}

private class MaybeApplyScheduler<T>(
    private val subscribeOn: Scheduler,
    private val observeOn: Scheduler
) : MaybeTransformer<T, T> {
    override fun apply(upstream: Maybe<T>): MaybeSource<T> =
        upstream.subscribeOn(subscribeOn)
            .observeOn(observeOn)
}

private class FlowableApplyScheduler<T>(
    private val subscribeOn: Scheduler,
    private val observeOn: Scheduler
) : FlowableTransformer<T, T> {
    override fun apply(upstream: Flowable<T>): Publisher<T> =
        upstream.subscribeOn(subscribeOn)
            .observeOn(observeOn)
}

interface Composer {

    fun <T> observable(): ObservableTransformer<T, T>

    fun completable(): CompletableTransformer

    fun <T> single(): SingleTransformer<T, T>

    fun <T> maybe(): MaybeTransformer<T, T>

    fun <T> flowable(): FlowableTransformer<T, T>

}