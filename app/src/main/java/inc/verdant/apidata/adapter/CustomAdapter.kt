package inc.verdant.apidata.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import inc.verdant.apidata.R
import inc.verdant.apidata.data.Userr


class CustomAdapter(private val dataSet: ArrayList<Userr>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val userName : TextView
        val passWord: TextView

        init {
          userName = view.findViewById<TextView>(R.id.textViewUserName)
          passWord = view.findViewById<TextView>(R.id.textViewUserPassword)
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.user_row_item, viewGroup, false)

        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.userName.text = dataSet[position].name
        viewHolder.passWord.text = dataSet[position].password
    }

    override fun getItemCount() = dataSet.size

}

