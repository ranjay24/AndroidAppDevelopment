package com.android.recylerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class ContactAdapter(
    var nameList: ArrayList<String>,
    var detailList: ArrayList<String>,
    var imageList: ArrayList<Int>,
    var context: Context ) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>()

{
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.card_design,parent,false)
    return ContactViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ContactViewHolder,
        position: Int
    ) {
        holder.textViewContactName.text = nameList.get(position)
        holder.textViewDetailName.text = detailList.get(position)
        holder.imageView.setImageResource(imageList.get(position))
        holder.cardView.setOnClickListener {
            Toast.makeText(context,"You selected the "+nameList.get(position), Toast.LENGTH_SHORT).show()

        }
    }

    override fun getItemCount(): Int {
        return nameList.size
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var textViewContactName : TextView = itemView.findViewById(R.id.textViewCountryName)
        var textViewDetailName : TextView = itemView.findViewById(R.id.textViewDetail)
        var imageView : CircleImageView = itemView.findViewById(R.id.image_View)
        var cardView : CardView = itemView.findViewById(R.id.cardView)
    }
}