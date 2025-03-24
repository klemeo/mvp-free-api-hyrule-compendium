package ru.android.hyrulecompendiummvp.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import ru.android.hyrulecompendiummvp.app.models.data.HyruleInfo

interface HyruleApi {

    @GET("compendium/category/{category}")
    fun getCompendiumCharacters(
        @Path("category") category: String
    ): Single<HyruleInfo>

}