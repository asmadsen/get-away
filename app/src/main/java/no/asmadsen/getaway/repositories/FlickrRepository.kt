package no.asmadsen.getaway.repositories

import io.reactivex.Single
import no.asmadsen.getaway.providers.flickr.FlickrApi
import no.asmadsen.getaway.providers.flickr.entities.PhotosResponse

class FlickrRepository(private val flickrApi: FlickrApi, private val apiKey: String) {
    fun fetchPhotosByLocation(latitude: Double, longitude: Double, page: Int = 1): Single<PhotosResponse> {
        return flickrApi.fetchPhotosByLocation(apiKey, latitude, longitude, page)
    }

    fun fetchPhotosByTags(vararg tags: String, page: Int = 1): Single<PhotosResponse> {
        return flickrApi.fetchPhotosByTags(apiKey, tags.joinToString(","), page)
    }
}
