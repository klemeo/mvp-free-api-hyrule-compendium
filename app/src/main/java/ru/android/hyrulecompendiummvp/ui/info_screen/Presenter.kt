package ru.android.hyrulecompendiummvp.ui.info_screen

import io.reactivex.Single
import org.koin.core.component.inject
import ru.android.hyrulecompendiummvp.app.models.data.HyruleInfo
import ru.android.hyrulecompendiummvp.app.models.repository.Repository
import ru.android.hyrulecompendiummvp.base.MvpPresenter
import ru.android.hyrulecompendiummvp.ui.mapper.HyruleToPresModel

class Presenter(
    view: View,
    private val category: String
) : MvpPresenter<View>(view) {

    private val repository: Repository by inject()

    private val hyruleToPresModelMapper = HyruleToPresModel()

    lateinit var hyruleInfo: HyruleInfo

    override fun onCreate() {
        loadHyruleInfo(category)
    }

    private fun loadHyruleInfo(category: String) {
        compositeDisposable.add(
            repository.getHyruleInfo(category)
                .flatMap {
                    hyruleInfo = it
                    Single.just(it)
                }
                .map {
                    hyruleToPresModelMapper.map(it)
                }
                .compose(composer.single())
                .subscribe({ character ->
                    view?.refreshHyruleInfo(character)
                    view?.showHyruleInfo(true)
                }, {
                    view?.showInfoDialog()
                })
        )
    }

}