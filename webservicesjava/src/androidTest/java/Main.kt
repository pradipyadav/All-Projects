package <default> (/media/sony/96D0-6DBE/STUDY/Android Class/Program/AndroidProject/webservicesjava/src/androidTest/java)

import com.google.gson.annotations.SerializedName
data class Main(
    @SerializedName("temp") val temp: Double,
    @SerializedName("temp_min") val tempMin: Double,
    @SerializedName("temp_max") val tempMax: Double,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("sea_level") val seaLevel: Double,
    @SerializedName("grnd_level") val grndLevel: Int,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("temp_kf") val tempKf: Int
)