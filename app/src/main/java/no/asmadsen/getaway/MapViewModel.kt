package no.asmadsen.getaway

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import no.asmadsen.getaway.providers.flickr.entities.PhotosResponse
import no.asmadsen.getaway.providers.sas.entities.LowestFareResponse
import no.asmadsen.getaway.providers.sas.entities.PassengerType
import no.asmadsen.getaway.repositories.AirportRepository
import no.asmadsen.getaway.repositories.FlickrRepository
import no.asmadsen.getaway.repositories.SasRepository
import no.asmadsen.getaway.room.dao.AirportDao
import no.asmadsen.getaway.room.dao.RegionDao
import no.asmadsen.getaway.room.entities.Airport
import no.asmadsen.getaway.room.entities.AirportOld
import no.asmadsen.getaway.room.entities.AirportWithCityAndDistance
import no.asmadsen.getaway.room.entities.AirportWithDistance
import java.util.*

class MapViewModel(
    application: Application,
    private val airportRepository: AirportRepository,
    private val flickrRepository: FlickrRepository,
    private val sasRepository: SasRepository
) : AndroidViewModel(application) {
    // TODO: Implement the ViewModel

    fun findRandomWithCity(latitude: Double, longitude: Double): Single<AirportWithCityAndDistance> {
        return airportRepository.findRandomWithCity(latitude, longitude)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun fetchPhotosByLocation(latitude: Double, longitude: Double, page: Int = 1): Single<PhotosResponse> {
        return flickrRepository.fetchPhotosByLocation(latitude, longitude, page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun fetchPhotosByTags(vararg tags: String, page: Int = 1): Single<PhotosResponse> {
        return flickrRepository.fetchPhotosByTags(*tags, page = page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getNearest(latitute : Double, longitute: Double) : List<Airport> {
        return listOf() //airportDao.getNearest(latitute, longitute)
        /*

        if (!::airports.isInitialized) {
            val text = this.getApplication<Application>().resources.openRawResource(R.raw.airports)
                .bufferedReader().use { it.readText() }

            airports = Json.parse(AirportOld.serializer().list, text)
        }
        val from = Location("")
        from.latitude = latitute
        from.longitude = longitute

        return airports
            .map {
                val to = Location("")
                to.latitude = it.latitude
                to.longitude = it.longitude
                AirportWithDistance(it.name, it.latitude, it.longitude, from.distanceTo(to))
            }
            .sortedBy { it.distance }.take(10)
            */
    }

    fun fetchLowFareToAirport(
        fromIata: String,
        toIata: String,
        startDate: Date,
        endDate: Date,
        passengerType: PassengerType
    ): Single<LowestFareResponse> {
        return sasRepository.fetchLowFareToAirport(fromIata, toIata, startDate, endDate, passengerType)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}

