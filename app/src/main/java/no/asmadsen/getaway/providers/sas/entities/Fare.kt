package no.asmadsen.getaway.providers.sas.entities

data class Fare(
    var basePrice: Double,
    var totalPrice: Double,
    var totalTax: Double,
    var formattedBasePrice: String,
    var formattedTotalPrice: String,
    var formattedTotalTax: String,
    var currency: String? = null,
    var points: Int? = null,
    var discountedPoints: Int? = null,
    var pointsAfterDiscount: Int? = null,
    var productName: String? = null,
    var lowestFare: Boolean? = false
)