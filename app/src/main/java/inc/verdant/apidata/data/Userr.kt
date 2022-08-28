package inc.verdant.apidata.data

import com.google.gson.annotations.SerializedName

data class Userr(
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String
)