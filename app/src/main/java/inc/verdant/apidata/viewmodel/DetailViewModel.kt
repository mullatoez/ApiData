package inc.verdant.apidata.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import inc.verdant.apidata.data.Post
import inc.verdant.apidata.data.User
import inc.verdant.apidata.network.RetrofitClient
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    val _post = MutableLiveData<Post>()
    val post: LiveData<Post>
        get() = _post

    val _user = MutableLiveData<User>()
    val user: LiveData<User>
        get() = _user

    fun getPostDetails(postId: Int) {
        val api = RetrofitClient.api
        GlobalScope.launch {
            _isLoading.value = true
            val fetchedPost = api.getPostById(postId)
            val fetchedUser = api.getUserById(fetchedPost.id)

            _post.value = fetchedPost
            _user.value = fetchedUser
            _isLoading.value = false
        }
    }

}