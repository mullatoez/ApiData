package inc.verdant.apidata.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    fun commentsApi(): ApiData? {
        return Retrofit.Builder()
            .baseUrl(ApiUrls.USERS_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(ApiData::class.java)
    }
}