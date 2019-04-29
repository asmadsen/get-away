package no.asmadsen.getaway.providers.sas.entities

data class SearchResponse (
    var originCity: City,
    var originAirport: Airport,
    var destinationCity: City,
    var destinationAirport: Airport,
    var currency: String,
    var flightProducts: List<FlightProduct>
)