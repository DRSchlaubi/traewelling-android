package de.hbch.traewelling.api.models.trip

import com.google.gson.annotations.SerializedName
import java.util.*

data class HafasTrainTripStation(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("rilIdentifier") val ds100: String,
    @SerializedName("arrival") val arrival: Date,
    @SerializedName("arrivalPlanned") val arrivalPlanned: Date,
    @SerializedName("arrivalReal") val arrivalReal: Date?,
    @SerializedName("arrivalPlatformPlanned") val arrivalPlatformPlanned: String,
    @SerializedName("arrivalPlatformReal") val arrivalPlatformReal: String,
    @SerializedName("departure") val departure: Date,
    @SerializedName("departurePlanned") val departurePlanned: Date,
    @SerializedName("departureReal") val departureReal: Date?,
    @SerializedName("departurePlatformPlanned") val departurePlatformPlanned: String,
    @SerializedName("departurePlatformReal") val departurePlatformReal: String,
    @SerializedName("platform") val platform: String,
    @SerializedName("isArrivalDelayed") val isArrivalDelayed: Boolean,
    @SerializedName("isDepartureDelayed") val isDepartureDelayed: Boolean,
    val cancelled: Boolean
) {
    val isCancelled: Boolean
        // DB Rest also shows last stop as cancelled
        get() = cancelled && departureReal == null && arrivalReal == null
}
