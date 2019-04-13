package no.asmadsen.getaway.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Single
import no.asmadsen.getaway.room.entities.City

@Dao
interface CityDao {
    @Insert
    fun insert(city: City) : Long

    @Query("SELECT * from cities")
    fun getAll(): List<City>


    @Query("SELECT * from cities WHERE id IN (:ids)")
    fun getById(vararg  ids: Long): Single<List<City>>

    @Query("SELECT * from cities WHERE countryId = :countryId")
    fun getByCountryId(countryId: Int): List<City>

    @Delete
    fun delete(vararg cities: City)
}