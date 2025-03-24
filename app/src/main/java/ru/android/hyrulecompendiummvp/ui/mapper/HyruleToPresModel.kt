package ru.android.hyrulecompendiummvp.ui.mapper

import org.koin.core.component.KoinComponent
import ru.android.hyrulecompendiummvp.app.models.data.HyruleInfo
import ru.android.hyrulecompendiummvp.app.models.pres_model.*

class HyruleToPresModel : KoinComponent {

    fun map(from: HyruleInfo) = HyruleInfoPresModel(
        data = from.data?.map {
            HyruleDataPresModel(
                id = it.id,
                category = it.category,
                name = it.name,
                image = it.image,
                description = it.description,
                commonLocations = it.commonLocations,
                attack = it.properties?.attack,
                defense = it.properties?.defense,
                drops = it.drops,
                cookingEffect = it.cookingEffect,
                heartsRecovered = it.heartsRecovered
            )
        }
    )

}