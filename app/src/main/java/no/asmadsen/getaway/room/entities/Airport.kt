package no.asmadsen.getaway.room.entities

import androidx.room.*

@Entity(
    tableName = "airports",
    indices = [
        Index(value = ["name"]),
        Index(value = ["iata"], unique = true),
        Index(value = ["cityId"])
    ],
    foreignKeys = [
        ForeignKey(
            entity = City::class,
            parentColumns = ["id"],
            childColumns = ["cityId"]
        )
    ]
)
data class Airport(
    @PrimaryKey val id: Long? = null,
    val name: String,
    val iata: String,
    val cityId: Long,
    val latitude: Double,
    val longitude: Double
)

class AirportWithDistance(
    val id: Long,
    val name: String,
    val iata: String,
    val cityId: Long,
    val latitude: Double,
    val longitude: Double,
    val distance: Float
)

open class AirportWithCity(
    val id: Long,
    val name: String,
    val iata: String,
    val cityId: Long,
    val city: City,
    val latitude: Double,
    val longitude: Double
)

class AirportWithCityAndDistance(
    id: Long,
    name: String,
    iata: String,
    cityId: Long,
    city: City,
    latitude: Double,
    longitude: Double,
    val distance: Float
) : AirportWithCity(id, name, iata, cityId, city, latitude, longitude)


