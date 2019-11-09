package com.jinmin.sopt.feather.git_follower

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jinmin.sopt.R
import com.jinmin.sopt.data.git_follower.GetGitFollowerData
import com.jinmin.sopt.data.git_follower.GetGitFollowerRepo
import com.jinmin.sopt.data.git_follower.GitFollowerRepository
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
    private val followerRepository : GitFollowerRepository = GetGitFollowerRepo()

    private var login = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_follower)

        login = intent.getStringExtra("login")
        Log.d("current_id", "login = $login")

        makeUser(login)
        makeFollowers(login)
    }

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

    private fun makeFollowers(login : String){
        adapter = GitFollowerAdapter(this)
        rvMainGitRepo.adapter = adapter

        rvMainGitRepo.layoutManager = LinearLayoutManager(this)
        rvMainGitRepo.addItemDecoration(object : RecyclerView.ItemDecoration(){
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                outRect.top = 15.dpToPx()
            }
        })

        followerRepository.getFollowers(login).enqueue(object : Callback<List<GetGitFollowerData>>{
            override fun onFailure(call: Call<List<GetGitFollowerData>>, t: Throwable) {
                Log.e("sopt_error_2","t = $t")
            }

            override fun onResponse(
                call: Call<List<GetGitFollowerData>>,
                response: Response<List<GetGitFollowerData>>
            ) {
                if(response.isSuccessful){
                    val followers = response.body()!!

                    adapter.data = followers
                    adapter.notifyDataSetChanged()
                }
            }
        })
    }
    private fun Int.dpToPx(): Int = TypedValue
        .applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(), resources.displayMetrics).toInt()
}
