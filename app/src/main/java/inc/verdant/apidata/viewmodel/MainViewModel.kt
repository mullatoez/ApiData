package inc.verdant.apidata.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import inc.verdant.apidata.data.Post
import inc.verdant.apidata.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val posts = MutableLiveData<List<Post>>()

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getPosts() {
        GlobalScope.launch(Dispatchers.Main) {
            _isLoading.value = true
            val fetchedposts = RetrofitClient.api.getPosts()
            Log.i("FETCHED_POSTS", "getPosts: $fetchedposts")
            posts.value = fetchedposts
            _isLoading.value = false
        }
    }
}