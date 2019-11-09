package com.jinmin.sopt.data.git_follower

import retrofit2.Call

interface GitFollowerRepository {
    fun getFollowers(login:String) : Call<List<GetGitFollowerData>>
}
