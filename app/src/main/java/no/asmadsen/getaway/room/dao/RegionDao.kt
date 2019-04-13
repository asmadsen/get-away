package no.asmadsen.getaway.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import no.asmadsen.getaway.room.entities.Region

@Dao
interface RegionDao {
    @Query("SELECT * FROM regions")
    fun getAll(): List<Region>

    @Query("SELECT * FROM regions WHERE id IN (:regionIds)")
    fun loadAllByIds(regionIds: IntArray): List<Region>

    @Query("SELECT * FROM regions WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Region?

    @Insert
    fun insertAll(vararg regions: Region): List<Long>

    @Insert
    fun insert(region: Region): Long
}