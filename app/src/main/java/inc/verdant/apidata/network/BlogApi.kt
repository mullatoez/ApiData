package inc.verdant.apidata.network

import inc.verdant.apidata.data.Post
import inc.verdant.apidata.data.User
import retrofit2.http.GET
import retrofit2.http.Path

interface BlogApi {

    @GET("/posts")
    suspend fun getPosts() : List<Post>

    @GET("/posts/{id}")
    suspend fun getPostById(@Path("id") postId: Int): Post

    @GET("/users/{id}")
    suspend fun getUserById(@Path("id") userId: Int): User
}