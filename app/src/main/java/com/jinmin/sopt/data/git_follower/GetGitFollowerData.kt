package com.jinmin.sopt.data.git_follower

import com.google.gson.annotations.SerializedName

data class GetGitFollowerData (
    @SerializedName("name")
    val name : String,
    @SerializedName("login")
    val login : String,
    @SerializedName("avatar_url")
    val avatar_url : String?
)