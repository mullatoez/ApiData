package inc.verdant.apidata.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name")
    val name: String,
    @SerializedName("password")
    val password: String
)