package inc.verdant.apidata.screens

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import inc.verdant.apidata.adapter.BlogPostAdapter
import inc.verdant.apidata.data.Post
import inc.verdant.apidata.databinding.ActivityRetrofitBinding
import inc.verdant.apidata.network.Constants.EXTRA_POST_ID
import inc.verdant.apidata.viewmodel.MainViewModel

private const val TAG = "RetrofitActivity"

class RetrofitActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRetrofitBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var blogPostAdapter: BlogPostAdapter
    private val blogPosts = mutableListOf<Post>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRetrofitBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.isLoading.observe(this, Observer {
            Log.i("TAG", "isLoading: $it")
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })


        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(this@RetrofitActivity)
        }

        viewModel.posts.observe(this, Observer {
            Log.i(TAG, "Posts Size:  ${it.size}")
            blogPostAdapter = BlogPostAdapter(it, object : BlogPostAdapter.OnItemClick {
                override fun onItemClick(post: Post) {
                    val intent = Intent(this@RetrofitActivity, DetailActivity::class.java)
                    intent.putExtra(EXTRA_POST_ID, post.id)
                    startActivity(intent)
                }
            })
            binding.recyclerview.adapter = blogPostAdapter
            blogPostAdapter.notifyDataSetChanged()
        })

        binding.getPostsButton.setOnClickListener {
            viewModel.getPosts()
        }
    }
}