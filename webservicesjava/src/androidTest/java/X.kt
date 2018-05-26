package <default> (/media/sony/96D0-6DBE/STUDY/Android Class/Program/AndroidProject/webservicesjava/src/androidTest/java)

import com.google.gson.annotations.SerializedName
data class X(
    @SerializedName("dt") val dt: Int,
    @SerializedName("main") val main: Main,
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("clouds") val clouds: Clouds,
    @SerializedName("wind") val wind: Wind,
    @SerializedName("snow") val snow: Snow,
    @SerializedName("sys") val sys: Sys,
    @SerializedName("dt_txt") val dtTxt: String
)