package no.asmadsen.getaway.room.entities

import kotlinx.serialization.Serializable

@Serializable
data class AirportOld(
    val id: Int,
    val name: String,
    val city: String,
    val country: String,
    val iata: String?,
    val icao: String?,
    val latitude: Double,
    val longitude: Double,
    val altitude: Double,
    val timezone: Double?,
    val dst: Char?,
    val tz: String?
)
