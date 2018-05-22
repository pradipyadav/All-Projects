package <default> (/media/sony/96D0-6DBE/STUDY/Android Class/Program/AndroidProject/webservices/src/test/java)

import com.google.gson.annotations.SerializedName
data class Currency(
    @SerializedName("code") val code: String,
    @SerializedName("name") val name: String,
    @SerializedName("symbol") val symbol: String
)