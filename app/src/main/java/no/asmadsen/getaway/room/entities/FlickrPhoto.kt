package no.asmadsen.getaway.room.entities

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class FlickrPhoto(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val title: String,
    val ispublic: Int,
    val isfriend: Int,
    val isfamily: Int
) {
    @Transient val url = "https://farm$farm.staticflickr.com/$server/${id}_${secret}_z.jpg"
}

@Serializable
data class FlickrResponse(
    val photos: FlickrPhotos,
    val stat: String
)

@Serializable
data class FlickrPhotos(
    val page: Int,
    val pages: Int,
    val perpage: Int,
    val total: Int,
    val photo: List<FlickrPhoto>
)