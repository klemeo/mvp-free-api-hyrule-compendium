package ru.android.hyrulecompendiummvp.app.models.data

import com.google.gson.annotations.SerializedName

class HyruleInfo(
    @SerializedName("data")
    val data: List<HyruleData>?
)