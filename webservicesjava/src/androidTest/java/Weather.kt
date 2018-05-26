package <default> (/media/sony/96D0-6DBE/STUDY/Android Class/Program/AndroidProject/webservicesjava/src/androidTest/java)

import com.google.gson.annotations.SerializedName
data class Weather(
    @SerializedName("id") val id: Int,
    @SerializedName("main") val main: String,
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String
)