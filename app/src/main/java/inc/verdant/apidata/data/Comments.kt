package inc.verdant.apidata.data

import com.google.gson.annotations.SerializedName

data class Comments(

    @SerializedName("name")
    val name: String,
    @SerializedName("body")
    val body: String,
    @SerializedName("email")
    val email: String
)