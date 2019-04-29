package no.asmadsen.getaway.providers.sas.entities

import java.util.*

data class FlightProduct (
    var outBoundDate: Date,
    var inBoundDate: Date,
    var lowestPrice: Price
) {
    data class Price(
        var basePrice: Double,
        var totalPrice: Double,
        var totalTax: Double,
        var formattedBasePrice: String,
        var formattedTotalPrice: String,
        var formattedTotalTax: String
    )
}