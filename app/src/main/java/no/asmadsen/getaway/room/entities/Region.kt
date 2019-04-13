package no.asmadsen.getaway.room.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "regions",
    indices = [
        Index(value = ["name"], unique = true)
    ]
)
data class Region(
    @PrimaryKey var id: Long? = null,
    var name: String
)