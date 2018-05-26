package <default> (/media/sony/96D0-6DBE/STUDY/Android Class/Program/AndroidProject/webservicesjava/src/androidTest/java)

import com.google.gson.annotations.SerializedName

data class CityWether(
    @SerializedName("cod") val cod: String,
    @SerializedName("message") val message: Double,
    @SerializedName("cnt") val cnt: Int,
    @SerializedName("list") val list: List<X>,
    @SerializedName("city") val city: City
)