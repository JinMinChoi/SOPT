package com.jinmin.sopt.data.git_repo

import retrofit2.Call
/*
class GitRepoRepository (){
    fun getRepoList() : List<GitRepoData>{
        return listOf(
            GitRepoData(
                name = "SoptStargram",
                desc = "IT 창업 동아리 SOPT 안드로이드 교육 프로젝트",
                language = "Kotlin",
                languageColor = 0,
                profile = 1,
                updated_at = "2019-xx-xx"
            ),
            GitRepoData(
                name = "artic_android",
                desc = "Forked from artic_development/artic_android",
                language = "Kotlin",
                languageColor = 0,
                profile = 1,
                updated_at = "2019-xx-xx"
            )
        )
    }
}*/

interface GitRepoRepository {
    fun getRepos(login:String) : Call<List<GetGitRepoData>>
}