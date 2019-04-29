package no.asmadsen.getaway.providers.flickr

import io.reactivex.Single
import no.asmadsen.getaway.providers.flickr.entities.PhotosResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FlickrApi {
    @GET("/services/rest/?method=flickr.photos.search&sort=relevance&tag_mode=any&tags=sightseeing&format=json&nojsoncallback=1&content_type=1&per_page=20&accuracy=6&radius=20")
    fun fetchPhotosByLocation(
        @Query("api_key") apiKey: String,
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("page") page: Int = 1
    ): Single<PhotosResponse>

    @GET("/services/rest/?method=flickr.photos.search&sort=relevance&tag_mode=all&tags=sightseeing&format=json&nojsoncallback=1&content_type=1&per_page=20")
    fun fetchPhotosByTags(
        @Query("api_key") apiKey: String,
        @Query("tags") tags: String,
        @Query("page") page: Int = 1
    ): Single<PhotosResponse>
}