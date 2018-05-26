package <default> (/media/sony/96D0-6DBE/STUDY/Android Class/Program/AndroidProject/webservicesjava/src/androidTest/java)

import com.google.gson.annotations.SerializedName
data class City(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("coord") val coord: Coord,
    @SerializedName("country") val country: String
)