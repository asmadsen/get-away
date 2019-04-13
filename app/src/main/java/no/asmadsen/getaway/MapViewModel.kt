package no.asmadsen.getaway

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import no.asmadsen.getaway.room.dao.AirportDao
import no.asmadsen.getaway.room.dao.RegionDao
import no.asmadsen.getaway.room.entities.Airport
import no.asmadsen.getaway.room.entities.AirportOld
import no.asmadsen.getaway.room.entities.AirportWithDistance

class MapViewModel(application: Application) : AndroidViewModel(application) {
    // TODO: Implement the ViewModel
    val positions = MutableLiveData<String>()

    private lateinit var airports : List<AirportOld>
    var airportDao : AirportDao = MyDatabase.getDatabase(application).airportDao()
    var regionDao : RegionDao = MyDatabase.getDatabase(application).regionDao()


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
}

