package com.jinmin.sopt.data.git_user

data class UserData(
    val profile : String?,
    val name : String,
    val login : String,
    val desc : String,
    val followerCnt : Int
)