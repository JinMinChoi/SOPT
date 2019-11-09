package com.jinmin.sopt.data.git_repo

import com.jinmin.sopt.api.GithubServiceImpl
import retrofit2.Call

class GetGitRepoRepo :GitRepoRepository{
    override fun getRepos(login: String): Call<List<GetGitRepoData>> {
        return GithubServiceImpl.service.getRepos(login)
    }
}