package com.jinmin.sopt.feather.git_follower

import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jinmin.sopt.R
import com.jinmin.sopt.data.git_follower.GetGitFollowerData
import com.jinmin.sopt.feather.git_repo.GitRepoActivity

class GitFollowerViewHolder (view: View) : RecyclerView.ViewHolder(view){

    val ctnRvFollower : View = view.findViewById(R.id.ctnRvFollower)
    val imgRvFollowerProfile : ImageView = view.findViewById(R.id.imgRvFollowerProfile)
    val txtRvFollowerId : TextView = view.findViewById(R.id.txtRvFollowerId)
    val txtRvFollowerName : TextView = view.findViewById(R.id.txtRvFollowerName)

    fun bind(data : GetGitFollowerData){
        imgRvFollowerProfile.setImageURI(Uri.parse(data.avatar_url))
        txtRvFollowerId.text = data.login
        txtRvFollowerName.text = data.name

        ctnRvFollower.setOnClickListener {
            val context = it.context

            val intent = Intent(context, GitRepoActivity::class.java)
            intent.putExtra("follower_login", data.login)
            context.startActivity(intent)
        }
    }
}