package inc.verdant.apidata.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import inc.verdant.apidata.adapter.CustomAdapter
import inc.verdant.apidata.databinding.ActivityUsersBinding
import inc.verdant.apidata.data.Userr
import inc.verdant.apidata.network.RetrofitClient.repositoryApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UsersActivity : AppCompatActivity() {


    private lateinit var binding: ActivityUsersBinding

    private val api = repositoryApi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.usersRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@UsersActivity)

        }

        GlobalScope.launch(Dispatchers.IO) {
            val users = api!!.getUsers()
            withContext(Dispatchers.Main){
                if (users.isSuccessful){
                    binding.usersRecyclerview.adapter = CustomAdapter(users.body()!! as ArrayList<Userr>)
                }
            }
        }
    }
}