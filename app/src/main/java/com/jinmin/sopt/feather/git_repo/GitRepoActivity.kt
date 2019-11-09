package com.jinmin.sopt.feather.git_repo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.jinmin.sopt.R
import com.jinmin.sopt.data.git_user.GetGitUserRepo
import com.jinmin.sopt.data.git_user.GetUserData
import com.jinmin.sopt.data.git_user.GitUserRepository
import kotlinx.android.synthetic.main.activity_git_follower.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitRepoActivity : AppCompatActivity() {

    private val userRepository: GitUserRepository = GetGitUserRepo()

    private var login = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_repo)

        //init()
        login = intent.getStringExtra("follower_login")
        makeUser(login)
    }

    /*private fun init(){
        rvMainGitRepo = findViewById(R.id.rvMainGitRepo)

        gitRepoAdapter = GitRepoAdapter(this)

        rvMainGitRepo.adapter = gitRepoAdapter

        rvMainGitRepo.layoutManager = LinearLayoutManager(this)

        gitRepoAdapter.data= gitRepoRepogitory.getRepoList()

        gitRepoAdapter.notifyDataSetChanged()
    }*/
    private fun makeUser(login : String){
        userRepository.getUser(login).enqueue(object : Callback<GetUserData> {
            override fun onFailure(call: Call<GetUserData>, t: Throwable) {
                Log.e("sopt_error","error : $t")
            }

            override fun onResponse(call: Call<GetUserData>, response: Response<GetUserData>) {
                if(response.isSuccessful){
                    val user = response.body()!!

                    txtUserId.text = user.login
                    txtUserName.text = user.name
                    txtUserDescription.text = user.bio
                }
            }
        })
    }
}
