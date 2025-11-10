package com.android.practicerecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class NewsAdapter(
    private val context: Context,
    private val list: ArrayList<News>
) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    // ViewHolder holds references to the views in each item
    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val heading: TextView = itemView.findViewById(R.id.heading)
        val image: ShapeableImageView = itemView.findViewById(R.id.shapeableImageView)
        val description: TextView = itemView.findViewById(R.id.decription) // fixed spelling
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemview, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentItem = list[position]

        // Bind data to your views
        holder.heading.text = currentItem.newHeading
        holder.description.text = currentItem.newsDescription
        holder.image.setImageResource(currentItem.newImage)  // if you’re using drawable resource
    }

    override fun getItemCount(): Int = list.size
}
