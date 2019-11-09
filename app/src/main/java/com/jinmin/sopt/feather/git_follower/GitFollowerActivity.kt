package com.jinmin.sopt.feather.git_follower

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

class GitFollowerActivity : AppCompatActivity() {


    private lateinit var adapter: GitFollowerAdapter
    private val userRepository : GitUserRepository = GetGitUserRepo()

    private var login = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_follower)

        login = intent.getStringExtra("login")
        Log.d("current_id", "login = $login")
        //init()

        makeUser(login)
    }

    /*private fun init(){
        rvGitFollower = findViewById(R.id.rvMainGitRepo)

        gitFollowerAdapter = GitFollowerAdapter(this)

        rvGitFollower.adapter = gitFollowerAdapter

        rvGitFollower.layoutManager = LinearLayoutManager(this)

        gitFollowerAdapter.data =gitFollowerRepository.getFollowerList()

        gitFollowerAdapter.notifyDataSetChanged()
    }*/

    private fun makeUser(login : String){
        userRepository.getUser(login).enqueue(object : Callback<GetUserData>{
            override fun onFailure(call: Call<GetUserData>, t: Throwable) {
                Log.e("sopt_error","error : $t")
            }

            override fun onResponse(call: Call<GetUserData>, response: Response<GetUserData>) {
                if(response.isSuccessful){
                    val user = response.body()!!

                    //imgUserProfile.setImageURI(Uri.parse(user.avatar_url))

                    txtUserId.text = user.login
                    txtUserName.text = user.name
                    txtUserDescription.text = user.bio
                }
            }
        })
    }
    private fun makeFollowers(){

    }
}
