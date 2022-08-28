package inc.verdant.apidata.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import inc.verdant.apidata.R
import inc.verdant.apidata.data.Post
import inc.verdant.apidata.databinding.PostItemRowBinding

class BlogPostAdapter(private val posts: List<Post>) :
    RecyclerView.Adapter<BlogPostAdapter.ViewHolder>() {

    inner class ViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        val binding = PostItemRowBinding.bind(itemview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_item_row, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = posts[position]
        with(holder.binding) {
            postIdText.text = post.id.toString()
            postTitleText.text = post.title
            postBodyText.text = post.body

        }
    }

    override fun getItemCount() = posts.size
}