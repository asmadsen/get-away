package no.asmadsen.getaway.repositories

import android.location.Location
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.rxkotlin.zipWith
import no.asmadsen.getaway.MyDatabase
import no.asmadsen.getaway.room.entities.AirportWithCity
import no.asmadsen.getaway.room.entities.AirportWithCityAndDistance

class AirportRepository(private val myDatabase: MyDatabase) {
    fun getAirportsByName(name: String): Single<List<AirportWithCity>> {
        val dbAirports = myDatabase.airportDao()
            .getByName(name)
        val dbCities = dbAirports.flatMap { airports ->
            myDatabase.cityDao().getById(*airports.map { it.cityId }.distinct().toLongArray())
        }

        return dbAirports.zipWith(dbCities) { airports, cities ->
            airports.map { airport ->
                AirportWithCity(
                    airport.id!!,
                    airport.name,
                    airport.iata,
                    airport.cityId,
                    cities.find { city -> city.id == airport.cityId }!!,
                    airport.latitude,
                    airport.longitude
                )
            }
        }
    }

    fun getNearestWithCityByName(name: String, latitude: Double, longitude: Double): Single<List<AirportWithCityAndDistance>> {
        val from = Location("")
        from.latitude = latitude
        from.longitude = longitude
        val dbAirports = myDatabase.airportDao()
            .getNearestByName(name, latitude, longitude, Math.pow(Math.cos(Math.toRadians(latitude)), 2.0))
        val dbCities = dbAirports.flatMap { airports ->
            myDatabase.cityDao().getById(*airports.map { it.cityId }.distinct().toLongArray())
        }

        return dbAirports.zipWith(dbCities) { airports, cities ->
            airports.map { airport ->
                val to = Location("")
                to.latitude = airport.latitude
                to.longitude = airport.longitude
                AirportWithCityAndDistance(
                    airport.id!!,
                    airport.name,
                    airport.iata,
                    airport.cityId,
                    cities.find { city -> city.id == airport.cityId }!!,
                    airport.latitude,
                    airport.longitude,
                    from.distanceTo(to)
                )
            }
        }
    }

    fun getNearestWithCity(latitude: Double, longitude: Double) : Single<List<AirportWithCityAndDistance>> {
        val from = Location("")
        from.latitude = latitude
        from.longitude = longitude
        val dbAirports = myDatabase.airportDao()
            .getNearest(latitude, longitude, Math.pow(Math.cos(Math.toRadians(latitude)), 2.0))
        val dbCities = dbAirports.flatMap { airports ->
            myDatabase.cityDao().getById(*airports.map { it.cityId }.distinct().toLongArray())
        }

        return dbAirports.zipWith(dbCities) { airports, cities ->
            airports.map { airport ->
                val to = Location("")
                to.latitude = airport.latitude
                to.longitude = airport.longitude
                AirportWithCityAndDistance(
                    airport.id!!,
                    airport.name,
                    airport.iata,
                    airport.cityId,
                    cities.find { city -> city.id == airport.cityId }!!,
                    airport.latitude,
                    airport.longitude,
                    from.distanceTo(to)
                )
            }
        }
    }

    fun findRandomWithCity(latitude: Double, longitude: Double): Single<AirportWithCityAndDistance> {
        val from = Location("")
        from.latitude = latitude
        from.longitude = longitude

        return myDatabase.airportDao().findRandomAirport().flatMap { airport ->
            val to = Location("")
            to.latitude = airport.latitude
            to.longitude = airport.longitude
            myDatabase.cityDao().getById(airport.cityId)
                .flatMapObservable { cities -> Observable.fromArray(*cities.toTypedArray()) }
                .filter { city -> city.id == airport.cityId }
                .firstOrError()
                .map { city ->
                    AirportWithCityAndDistance(
                        airport.id!!,
                        airport.name,
                        airport.iata,
                        airport.cityId,
                        city,
                        airport.latitude,
                        airport.longitude,
                        from.distanceTo(to)
                    )
                }
        }
    }
}