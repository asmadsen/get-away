package no.asmadsen.getaway

import android.app.Application
import android.location.Location
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import no.asmadsen.getaway.room.entities.Airport
import no.asmadsen.getaway.room.entities.AirportWithCityAndDistance
import no.asmadsen.getaway.repositories.AirportRepository
import org.jetbrains.anko.doAsync

class ApplicationViewModel(application: Application, private val airportRepository: AirportRepository) : AndroidViewModel(application) {
    val airports = MutableLiveData<List<Airport>>()
    val airport = MutableLiveData<String>()
    val userLocation = MutableLiveData<Location>()

    init {
        doAsync {
            val dbAirports = MyDatabase.getDatabase(application).airportDao().getAll()
            airports.postValue(dbAirports)
        }
    }

    fun getNearestAirports(name: String? = null, latitude: Double, longitude: Double): Single<List<AirportWithCityAndDistance>> {
        if (!name.isNullOrBlank() && name.length > 2) {
            return airportRepository.getNearestWithCityByName(name, latitude, longitude)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
        }
        return airportRepository.getNearestWithCity(latitude, longitude)
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
    }
}