package dev.archfoundry.marsphotosapp.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MarsPhoto(
    val id: String,
    @SerialName("img_src") val imgSrc : String
) {
}