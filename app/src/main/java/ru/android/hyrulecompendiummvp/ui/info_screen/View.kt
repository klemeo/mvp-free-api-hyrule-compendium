package ru.android.hyrulecompendiummvp.ui.info_screen

import ru.android.hyrulecompendiummvp.app.models.pres_model.HyruleInfoPresModel

interface View {

    fun refreshHyruleInfo(hyruleInfo: HyruleInfoPresModel)

    fun showHyruleInfo(animated: Boolean)

}