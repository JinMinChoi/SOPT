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
import com.jinmin.sopt.feather.user_view.UserFragment
import kotlinx.android.synthetic.main.activity_git_follower.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitFollowerActivity : AppCompatActivity() {

    private lateinit var adapter: GitFollowerAdapter

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
        val userFragment = UserFragment.setLogin(login)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.ctn_user_follower, userFragment)
        transaction.commit()
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