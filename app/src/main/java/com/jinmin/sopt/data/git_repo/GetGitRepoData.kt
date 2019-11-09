package com.jinmin.sopt.data.git_repo

import com.google.gson.annotations.SerializedName

data class GetGitRepoData(
    @SerializedName("name")
    val name : String,
    @SerializedName("description")
    val desc : String,
    @SerializedName("language")
    val language: String?,
    @SerializedName("lauguages_url")
    val lauguageColor : Int?,
    @SerializedName("avatar_url")
    val avatar_url : String?,
    @SerializedName("updated_at")
    val updated_at : String?
)