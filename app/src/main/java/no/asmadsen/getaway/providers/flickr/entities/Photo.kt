package no.asmadsen.getaway.providers.flickr.entities

data class Photo(
    var id: String,
    var owner: String? = null,
    var secret: String? = null,
    var server: String? = null,
    var farm: Int? = null,
    var title: String? = null,
    var ispublic: Boolean = false,
    var isfriend: Boolean = false,
    var isfamily: Boolean = false
)