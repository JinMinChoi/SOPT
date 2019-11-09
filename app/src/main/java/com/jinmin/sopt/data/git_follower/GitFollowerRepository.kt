package com.jinmin.sopt.data.git_follower

import retrofit2.Call
/*
class GitFollowerRepository {
    fun getFollowerList() : List<GitFollowerData>{
        return listOf(
            GitFollowerData(
                login = "201401503",
                name = "JinMinChoi",
                profile = 0
            ),
            GitFollowerData(
                login = "201401503",
                name = "JinMinChoi",
                profile = 0
            )
        )
    }
}*/

interface GitFollowerRepository {
    fun getFollowers(login:String) : Call<List<GetGitFollowerData>>
}
