package no.asmadsen.getaway.room.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "countries",
    indices = [
        Index(value = ["name"], unique = true),
        Index(value = ["code"], unique = true)
    ]
)
data class Country(
    @PrimaryKey var id: Long? = null,
    var name: String,
    var code: String
)