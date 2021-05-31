package ru.android.hyrulecompendiummvp.app.models.repository

import io.reactivex.Single
import ru.android.hyrulecompendiummvp.api.HyruleApi
import ru.android.hyrulecompendiummvp.app.models.data.HyruleInfo

class RepositoryImpl(
    private val api: HyruleApi
) : Repository {

    override fun getHyruleInfo(category: String): Single<HyruleInfo> =
        api.getCharacters(category).flatMap { response ->
            if (response.data != null) {
                Single.just(response)
            } else {
                Single.error(Throwable("Request failed"))
            }
        }

}