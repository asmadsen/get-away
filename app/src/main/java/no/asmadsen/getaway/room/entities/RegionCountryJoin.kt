package no.asmadsen.getaway.room.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "region_country_join",
    primaryKeys = ["regionId", "countryId"],
    indices = [
        Index(value = ["regionId"]),
        Index(value = ["countryId"])
    ],
    foreignKeys = [
        ForeignKey(
            entity = Region::class,
            parentColumns = ["id"],
            childColumns = ["regionId"]
        ),
        ForeignKey(
            entity = Country::class,
            parentColumns = ["id"],
            childColumns = ["countryId"]
        )
    ]
)
data class RegionCountryJoin(
    val regionId: Long,
    val countryId: Long
)