package com.jinmin.sopt.data.git_follower

import com.jinmin.sopt.api.GithubServiceImpl
import retrofit2.Call

class GetGitFollowerRepo : GitFollowerRepository{
    override fun getFollowers(login: String): Call<List<GetGitFollowerData>> {
        return GithubServiceImpl.service.getFollowers(login)
    }
}