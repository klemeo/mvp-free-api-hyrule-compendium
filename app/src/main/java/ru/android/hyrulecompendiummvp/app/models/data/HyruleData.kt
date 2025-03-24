package ru.android.hyrulecompendiummvp.app.models.data

import com.google.gson.annotations.SerializedName

class HyruleData(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("category")
    val category: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("common_locations")
    val commonLocations: List<String>?,
    @SerializedName("properties")
    val properties: Properties? = null,
    @SerializedName("drops")
    val drops: List<String>?,
    @SerializedName("cooking_effect")
    val cookingEffect: String?,
    @SerializedName("hearts_recovered")
    val heartsRecovered: Double?
)

class Properties(
    @SerializedName("attack")
    val attack: Int?,
    @SerializedName("defense")
    val defense: Int?,
)