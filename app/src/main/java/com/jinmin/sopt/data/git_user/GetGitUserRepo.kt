package com.jinmin.sopt.data.git_user

import com.jinmin.sopt.api.GithubServiceImpl
import retrofit2.Call

class GetGitUserRepo : GitUserRepository{
    override fun getUser(login: String): Call<GetUserData> {
        return GithubServiceImpl.service.getUser(login)
    }
}