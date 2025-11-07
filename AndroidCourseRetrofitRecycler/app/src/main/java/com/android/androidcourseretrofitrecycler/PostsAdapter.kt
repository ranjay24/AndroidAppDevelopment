package com.android.androidcourseretrofitrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.androidcourseretrofitrecycler.Posts
import com.android.androidcourseretrofitrecycler.databinding.PostItemBinding

class PostsAdapter(var postsList : ArrayList<Posts>)  : RecyclerView.Adapter<PostsAdapter.PostsViewHolder>(){

    inner class PostsViewHolder(var adapterBinding : PostItemBinding)
        : RecyclerView.ViewHolder(adapterBinding.root){}


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostsViewHolder {
       val binding = PostItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PostsViewHolder,
        position: Int
    ) {
        holder.adapterBinding.textViewUserId.text = postsList[position].userId.toString()
        holder.adapterBinding.textViewId.text = postsList[position].id.toString()
        holder.adapterBinding.textViewTitle.text = postsList[position].title
        holder.adapterBinding.textViewBody.text = postsList[position].subTitle
    }

    override fun getItemCount(): Int {
        return postsList.size
    }


}