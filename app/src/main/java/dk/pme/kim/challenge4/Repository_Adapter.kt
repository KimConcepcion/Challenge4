package dk.pme.kim.challenge4

import android.content.Context
import android.content.Intent
import android.nfc.Tag
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.view.*
import org.w3c.dom.Text
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class Repository_Adapter(private val repos : ArrayList<Repository>, private val mcontext : Context)
    : RecyclerView.Adapter<Repository_Adapter.MyViewHolder>()
{
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        var parentLayout : RelativeLayout? = null
        var txtName : TextView? = null
        var txtDate : TextView? = null
        var txtOwner : TextView? = null
        var txtStars : TextView? = null

        init
        {
            this.parentLayout = itemView.findViewById<RelativeLayout>(R.id.parentLayout)
            this.txtName = itemView.findViewById<TextView>(R.id.txtName)
            this.txtDate = itemView.findViewById<TextView>(R.id.txtDate)
            this.txtOwner = itemView.findViewById<TextView>(R.id.txtOwner)
            this.txtStars = itemView.findViewById<TextView>(R.id.txtStars)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var listItemView : View
        listItemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false)
        return MyViewHolder(listItemView)
    }

    //  Combine data and created views here:
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Log.d("Repository_Adapter", "onBindViewHolder: Called!")

        val repo = repos[position]

        //  Get timestamp:
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        repo.date = current.format(formatter)

        //  update views:
        holder.txtName?.text = repo.name
        holder.txtDate?.text = repo.date
        holder.txtOwner?.text = repo.owner
        holder.txtStars?.text = repo.stars.toString()

        //  Click listener:
        holder.parentLayout?.setOnClickListener(View.OnClickListener {
            val intent : Intent = Intent(mcontext, GitHubInfoActivity::class.java)
            intent.putExtra("extra_name", repo.name)
            intent.putExtra("extra_date", repo.date)
            intent.putExtra("extra_owner", repo.owner)
            intent.putExtra("extra_stars", repo.stars.toString())
            mcontext.startActivity(intent)
        })
    }

    //  Gets the amount of repositories in the list:
    override fun getItemCount(): Int = repos.size
}