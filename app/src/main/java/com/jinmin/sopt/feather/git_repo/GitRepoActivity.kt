package com.jinmin.sopt.feather.git_repo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jinmin.sopt.R
import com.jinmin.sopt.data.git_repo.GitRepoRepository

class GitRepoActivity : AppCompatActivity() {

    private lateinit var rvMainGitRepo : RecyclerView
    private lateinit var gitRepoAdapter: GitRepoAdapter

    private val gitRepoRepogitory = GitRepoRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_repo)

        init()
    }

    private fun init(){
        rvMainGitRepo = findViewById(R.id.rvMainGitRepo)

        gitRepoAdapter = GitRepoAdapter(this)

        rvMainGitRepo.adapter = gitRepoAdapter

        rvMainGitRepo.layoutManager = LinearLayoutManager(this)

        gitRepoAdapter.data= gitRepoRepogitory.getRepoList()

        gitRepoAdapter.notifyDataSetChanged()
    }
}
