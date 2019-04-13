package no.asmadsen.getaway.services

import android.content.Context
import com.android.volley.Request.Method.GET
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.serialization.json.Json
import no.asmadsen.getaway.room.entities.FlickrPhoto
import no.asmadsen.getaway.room.entities.FlickrResponse


class FlickrService(val context: Context) {

    fun fetchPhotosByLocation(latitude: Double, longitude: Double, offset: Int = 0, listener: (List<FlickrPhoto>) -> Unit) {
        val queue = Volley.newRequestQueue(context)

        val request = StringRequest(
            GET,
            "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=$API_KEY&lat=$latitude&lon=$longitude&format=json&per_page=20",
            { response ->
                val flickrResponse = Json.parse(FlickrResponse.serializer(), response.drop(14).dropLast(1))
                listener.invoke(flickrResponse.photos.photo)
            }, null)
        queue.add(request)
        queue.start()
    }

    companion object {
        private const val API_KEY = "a46d54fa82cfcc316de13fab2920af4e"
    }
}