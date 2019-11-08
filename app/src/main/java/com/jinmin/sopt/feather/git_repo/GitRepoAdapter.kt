package com.jinmin.sopt.feather.git_repo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jinmin.sopt.R
import com.jinmin.sopt.data.git_repo.GitRepoData

class GitRepoAdapter (private val context: Context) : RecyclerView.Adapter<GitRepoViewHolder>(){

    var data = listOf<GitRepoData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GitRepoViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.rv_item_repository,parent,false)
        return GitRepoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: GitRepoViewHolder, position: Int) {
        holder.bind(data[position])
    }
}