package com.jinmin.sopt.api

import com.jinmin.sopt.data.git_follower.GetGitFollowerData
import com.jinmin.sopt.data.git_repo.GetGitRepoData
import com.jinmin.sopt.data.git_user.GetUserData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("/users/{login}")
    fun getUser(
        @Path("login") login: String
    ) : Call<GetUserData>

    @GET("/users/{login}/followers")
    fun getFollowers(
        @Path("login") login : String
    ) : Call<List<GetGitFollowerData>>

    @GET("/users/{login}/repos")
    fun getRepos(
        @Path("login") login : String
    ) : Call<List<GetGitRepoData>>
}