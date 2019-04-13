package no.asmadsen.getaway.utils

import androidx.room.TypeConverter
import no.asmadsen.getaway.room.entities.DaylightSavingTime

class RoomConverters {
    @TypeConverter
    fun fromDaylightSavingTime(dst : DaylightSavingTime) : String {
        return dst.name
    }

    @TypeConverter
    fun toDaylightSavingTime(input: String): DaylightSavingTime {
        return DaylightSavingTime.valueOf(input)
    }
}