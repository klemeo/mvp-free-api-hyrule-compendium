package ru.android.hyrulecompendiummvp.app.models.pres_model

class HyruleDataPresModel(
    val id: Int?,
    val category: String?,
    val name: String?,
    val image: String?,
    val description: String?,
    val commonLocations: List<String>?,
    val attack: Int?,
    val defense: Int?,
    val drops: List<String>?,
    val cookingEffect: String?,
    val heartsRecovered: Int?
)