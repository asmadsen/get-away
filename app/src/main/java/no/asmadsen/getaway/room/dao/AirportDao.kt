package no.asmadsen.getaway.room.dao

import android.location.Location
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.rxkotlin.toObservable
import no.asmadsen.getaway.room.entities.Airport
import no.asmadsen.getaway.room.entities.AirportWithCityAndDistance

@Dao
interface AirportDao {
    @Insert
    fun insert(airport : Airport) : Long

    @Insert
    fun insertAll(vararg airports: Airport): List<Long>

    @Query("SELECT * from airports")
    fun getAll(): List<Airport>

    @Query("SELECT * from airports WHERE cityId = :cityId")
    fun getByCityId(cityId: Int): List<Airport>

    @Query("SELECT * FROM airports ORDER BY ((:latitude - latitude) * (:latitude - latitude) + (:longitude - longitude) * (:longitude - longitude) * :fudge) LIMIT 30")
    fun getNearest(latitude: Double, longitude: Double, fudge: Double): Single<List<Airport>>

    @Query("SELECT * FROM airports WHERE name LIKE '%' || :name || '%' ORDER BY ((:latitude - latitude) * (:latitude - latitude) + (:longitude - longitude) * (:longitude - longitude) * :fudge) LIMIT 30")
    fun getNearestByName(name: String, latitude: Double, longitude: Double, fudge: Double): Single<List<Airport>>

    @Query("SELECT * from airports WHERE name LIKE '%' || :name || '%' LIMIT 20")
    fun getByName(name: String): List<Airport>

    @Query("SELECT * from airports WHERE id = :id LIMIT 1")
    fun findById(id : Int) : Airport?

    @Delete
    fun delete(vararg airports: Airport)
}