package com.jinmin.sopt.data.git_user

import retrofit2.Call

interface GitUserRepository {
    fun getUser(login : String) : Call<GetUserData>
}