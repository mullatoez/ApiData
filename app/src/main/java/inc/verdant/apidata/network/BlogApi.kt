package inc.verdant.apidata.network

import inc.verdant.apidata.data.Post
import retrofit2.http.GET

interface BlogApi {

    @GET("/posts")
    suspend fun getPosts() : List<Post>
}