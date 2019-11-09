package com.jinmin.sopt.data.git_repo

data class GitRepoData(
    val name : String,
    val desc : String,
    val language : String,
    val languageColor : Int?,
    val avatar_url : String?,
    val updated_at : String?
)