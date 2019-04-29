package no.asmadsen.getaway.providers.sas

import io.reactivex.Single
import no.asmadsen.getaway.providers.sas.entities.LowestFareResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SasApi {
    /*
    @GET("/offers/flights?displayType=CALENDAR&channel=web&bookingFlow=REVENUE&pos=no")
    fun fetchLowFareCalendarByMonth(
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("outDate") departureDate: String,
        @Query("inDate") returnDate: String,
        @Query("adt") adults: Int = 0,
        @Query("yth") youths: Int = 0,
        @Query("chd") children: Int = 0
    )
    */

    @GET("/offers/flightproduct/lowestFare?displayType=DAY&pos=NO&tripType=R")
    fun fetchLowFareToAirport(
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("startDate") startDate: String,
        @Query("endDate") endDate: String,
        @Query("paxType") passengerType: String
    ): Single<LowestFareResponse>
}