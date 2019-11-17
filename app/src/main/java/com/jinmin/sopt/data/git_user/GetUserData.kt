package com.jinmin.sopt.data.git_user

import com.google.gson.annotations.SerializedName

data class GetUserData(
    @SerializedName("avatar_url")
    val avatar_url : String?,
    @SerializedName("name")
    val name : String,
    @SerializedName("login")
    val login : String,
    @SerializedName("bio")
    val bio : String,
    @SerializedName("followers")
    val numOfFollowers : Int
)