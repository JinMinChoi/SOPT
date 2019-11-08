package com.jinmin.sopt.feather.git_follower

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jinmin.sopt.R
import com.jinmin.sopt.data.git_follower.GitFollowerRepository

class GitFollowerActivity : AppCompatActivity() {

    private lateinit var rvGitFollower : RecyclerView
    private lateinit var gitFollowerAdapter: GitFollowerAdapter

    private val gitFollowerRepository = GitFollowerRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_follower)

        init()
    }

    private fun init(){
        rvGitFollower = findViewById(R.id.rvGitFollower)

        gitFollowerAdapter = GitFollowerAdapter(this)

        rvGitFollower.adapter = gitFollowerAdapter

        rvGitFollower.layoutManager = LinearLayoutManager(this)

        gitFollowerAdapter.data =gitFollowerRepository.getFollowerList()

        gitFollowerAdapter.notifyDataSetChanged()
    }
}
