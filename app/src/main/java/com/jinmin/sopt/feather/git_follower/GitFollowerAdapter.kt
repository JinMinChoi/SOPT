package com.jinmin.sopt.feather.git_follower

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jinmin.sopt.R
import com.jinmin.sopt.data.git_follower.GetGitFollowerData

class GitFollowerAdapter (private val context: Context) : RecyclerView.Adapter<GitFollowerViewHolder>(){

    var data : List<GetGitFollowerData> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitFollowerViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_item_follower,parent,false)
        return GitFollowerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: GitFollowerViewHolder, position: Int) {

        holder.bind(data[position])
    }
}