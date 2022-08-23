package inc.verdant.apidata.network

import inc.verdant.apidata.model.Comments
import inc.verdant.apidata.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiData {

    @GET("/comments")
    suspend fun getComments(): Response<List<Comments>>

    @GET("/users")
    suspend fun getUsers(): Response<List<User>>

    @GET("/users/{id}")
    suspend fun getSpecificUser(@Path("id") id: String): Response<User>

    @POST("/users")
    suspend fun createUser(@Body user: User): Response<User>
}