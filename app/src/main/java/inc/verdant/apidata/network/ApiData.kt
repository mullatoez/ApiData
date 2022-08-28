package inc.verdant.apidata.network

import inc.verdant.apidata.data.Comments
import inc.verdant.apidata.data.Userr
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiData {

    @GET("/comments")
    suspend fun getComments(): Response<List<Comments>>

    @GET("/users")
    suspend fun getUsers(): Response<List<Userr>>

    @GET("/users/{id}")
    suspend fun getSpecificUser(@Path("id") id: String): Response<Userr>

    @POST("/users")
    suspend fun createUser(@Body userr: Userr): Response<Userr>
}