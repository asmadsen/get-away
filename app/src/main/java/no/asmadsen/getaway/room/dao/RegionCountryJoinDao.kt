package no.asmadsen.getaway.room.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import no.asmadsen.getaway.room.entities.RegionCountryJoin

@Dao
interface RegionCountryJoinDao {
    @Insert
    fun insert(vararg regionCountry : RegionCountryJoin)

    @Delete
    fun delete(vararg regionCountry : RegionCountryJoin)
}