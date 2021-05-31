package ru.android.hyrulecompendiummvp.app.models.repository

import io.reactivex.Single
import ru.android.hyrulecompendiummvp.app.models.data.HyruleInfo

interface Repository {

    fun getHyruleInfo(category: String): Single<HyruleInfo>

}