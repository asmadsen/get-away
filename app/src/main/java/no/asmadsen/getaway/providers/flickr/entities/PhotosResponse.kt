package no.asmadsen.getaway.providers.flickr.entities

data class PhotosResponse(
    var photos: Photos,
    var stat: String? = null
)