package no.asmadsen.getaway

import android.content.Context
import androidx.room.Room
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import no.asmadsen.getaway.room.dao.*
import no.asmadsen.getaway.room.entities.*
import no.asmadsen.getaway.utils.RoomConverters
import java.util.concurrent.Executors

@Database(
    entities = [
        Region::class,
        Country::class,
        RegionCountryJoin::class,
        City::class,
        Airport::class
    ],
    version = 1
)
@TypeConverters(RoomConverters::class)
abstract class MyDatabase : RoomDatabase() {
    abstract fun airportDao(): AirportDao
    abstract fun regionDao(): RegionDao
    abstract fun countryDao(): CountryDao
    abstract fun regionCountryJoinDao(): RegionCountryJoinDao
    abstract fun cityDao(): CityDao


    companion object {
        @Volatile
        private var INSTANCE: MyDatabase? = null

        fun getDatabase(context: Context): MyDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    "MyDatabase"
                )
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)

                            Executors.newSingleThreadExecutor().execute {
                                populateDatabase(getDatabase(context))
                            }
                        }
                    })
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}