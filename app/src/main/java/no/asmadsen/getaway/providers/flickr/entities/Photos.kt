package no.asmadsen.getaway.providers.flickr.entities

data class Photos(
    var page: Int,
    var pages: Int,
    var perpage: Int,
    var total: String,
    var photo: List<Photo>
)