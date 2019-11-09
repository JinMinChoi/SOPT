package com.jinmin.sopt.data.git_repo

import retrofit2.Call

interface GitRepoRepository {
    fun getRepos(login:String) : Call<List<GetGitRepoData>>
}