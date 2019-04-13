package no.asmadsen.getaway.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import no.asmadsen.getaway.room.entities.Country

@Dao
interface CountryDao {
    @Insert
    fun insert(country : Country) : Long

    @Query("SELECT * from countries")
    fun getAll(): List<Country>

    @Query("SELECT * from countries WHERE id = :id LIMIT 1")
    fun findById(id : Int) : Country?

    @Delete
    fun delete(vararg countries: Country)
}