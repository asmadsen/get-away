package no.asmadsen.getaway.room.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "cities",
    indices = [
        Index(value = ["code"], unique = true),
        Index(value = ["countryId"])
    ],
    foreignKeys = [
        ForeignKey(
            entity = Country::class,
            parentColumns = ["id"],
            childColumns = ["countryId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class City (
    @PrimaryKey val id: Long? = null,
    var name: String,
    var code: String,
    val countryId: Long
)
