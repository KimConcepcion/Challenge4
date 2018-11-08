package dk.pme.kim.challenge4

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import org.w3c.dom.Text


class Repository_Adapter(private val dataset : ArrayList<Repository>) : RecyclerView.Adapter<Repository_Adapter.viewHolder>()
{
    //  Viewholder:
    class viewHolder(itemView : RecyclerView) : RecyclerView.ViewHolder(itemView)
    {
        var txtName : TextView? = null
        var txtDate : TextView? = null
        var txtOwner : TextView? = null
        var txtStars : TextView? = null

        init
        {
            this.txtName = itemView.findViewById<TextView>(R.id.txtName)
            this.txtDate = itemView.findViewById<TextView>(R.id.txtDate)
            this.txtOwner = itemView.findViewById<TextView>(R.id.txtOwner)
            this.txtStars = itemView.findViewById<TextView>(R.id.txtStars)
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): viewHolder {
        return p0 as viewHolder
    }

    override fun onBindViewHolder(p0: viewHolder, p1: Int) {

    }

    override fun getItemCount(): Int = dataset.size
}