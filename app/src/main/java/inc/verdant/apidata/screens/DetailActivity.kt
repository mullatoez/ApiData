package inc.verdant.apidata.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import inc.verdant.apidata.R
import inc.verdant.apidata.databinding.ActivityDetailBinding
import inc.verdant.apidata.network.Constants.EXTRA_POST_ID

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val postId = intent.getIntExtra(EXTRA_POST_ID,-1)
        binding.mainText.text = postId.toString()
    }
}