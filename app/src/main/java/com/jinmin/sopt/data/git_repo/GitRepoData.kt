package com.jinmin.sopt.data.git_repo

data class GitRepoData(
    val name : String,
    val desc : String,
    val language : String,
    val languageColor : Int?,
    val profile : Int?,
    val updated_at : String
)