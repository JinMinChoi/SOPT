package com.jinmin.sopt.feather.git_repo

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jinmin.sopt.R
import com.jinmin.sopt.data.git_repo.GetGitRepoData

class GitRepoViewHolder(view: View): RecyclerView.ViewHolder(view){

    val ctnRvItem : View = view.findViewById(R.id.ctnRvItem)
    val txtRvItemName : TextView = view.findViewById(R.id.txtRvItemName)
    val txtRvItemDescription : TextView = view.findViewById(R.id.txtRvItemDescription)
    val imgRvItemLanguageColor : ImageView = view.findViewById(R.id.imgRvItemLanguageColor)
    val txtRvItemLanguage : TextView = view.findViewById(R.id.txtRvItemLanguage)
    val txtRvItemUpdatedAt : TextView = view.findViewById(R.id.txtRvItemUpdatedAt)

    fun bind(data: GetGitRepoData){

        txtRvItemName.text = data.name
        txtRvItemDescription.text = data.desc
        txtRvItemLanguage.text = data.language
        txtRvItemUpdatedAt.text = data.updated_at
        Glide
            .with(itemView)
            .load(data.languageColor)
            .placeholder(R.drawable.sopt_logo)
            .into(imgRvItemLanguageColor)
    }
}