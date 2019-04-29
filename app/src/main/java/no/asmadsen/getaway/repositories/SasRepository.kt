package no.asmadsen.getaway.repositories

import android.text.format.DateFormat
import io.reactivex.Single
import no.asmadsen.getaway.providers.sas.SasApi
import no.asmadsen.getaway.providers.sas.entities.LowestFareResponse
import no.asmadsen.getaway.providers.sas.entities.PassengerType
import java.text.SimpleDateFormat
import java.util.*

class SasRepository(private val sasApi: SasApi) {
    val lowestFareDateFormatter = SimpleDateFormat("yyyyMMdd")
    fun fetchLowFareToAirport(from: String,
                              to: String,
                              startDate: Date,
                              endDate: Date,
                              passengerType: PassengerType): Single<LowestFareResponse> {
        return sasApi.fetchLowFareToAirport(
            from,
            to,
            lowestFareDateFormatter.format(startDate) + "0000",
            lowestFareDateFormatter.format(endDate) + "0000",
            passengerType.slug
        )
    }

    private fun formatLowFareDate(date: Date): String {
        return "${DateFormat.format("yyyyMMdd", date)}0000"
    }
}