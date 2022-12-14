package inc.verdant.apidata.screens

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import inc.verdant.apidata.databinding.ActivityMainBinding
import inc.verdant.apidata.data.Userr
import inc.verdant.apidata.network.RetrofitClient.repositoryApi
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val api = repositoryApi()

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.saveBtn.setOnClickListener {
            val intent = Intent(this, UsersActivity::class.java)
            startActivity(intent)
        }

        //saveUser()

        /* binding.button.setOnClickListener {
             loadUserSuspend()
         }

         binding.saveBtn.setOnClickListener {
             saveUser()
         }*/
    }

    private fun loadUserSuspend() {
        GlobalScope.launch(Dispatchers.IO) {
            val id = binding.editTextId.text.toString()
            val specificUser = api!!.getSpecificUser(id)
            if (specificUser.isSuccessful) {
                val user = specificUser.body()
                withContext(Dispatchers.Main) {
                    binding.mainTextView.text = user!!.name
                }
            }
        }
    }

    private fun saveUser() {
        binding.saveBtn.setOnClickListener {
            val name = binding.ditTextName.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()


            GlobalScope.launch(Dispatchers.IO) {
                api!!.createUser(Userr(name = name, password = password))
            }


        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun loadUser() {
        val id = binding.editTextId.text.toString()
        GlobalScope.launch(Dispatchers.IO) {
            val specificUser = api!!.getSpecificUser(id)
            if (specificUser.isSuccessful) {
                val user = specificUser.body()
                binding.mainTextView.text = user!!.name
            }
        }
    }


    private fun initRecyclerView() {
        /* binding.mainRecyclerview.apply {
             layoutManager = LinearLayoutManager(this@MainActivity)
         }*/
    }
}