package <default> (/media/sony/96D0-6DBE/STUDY/Android Class/Program/AndroidProject/webservices/src/test/java)

import com.google.gson.annotations.SerializedName
data class Language(
    @SerializedName("iso639_1") val iso6391: String,
    @SerializedName("iso639_2") val iso6392: String,
    @SerializedName("name") val name: String,
    @SerializedName("nativeName") val nativeName: String
)