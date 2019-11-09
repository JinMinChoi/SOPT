package com.jinmin.sopt.feather.git_repo

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jinmin.sopt.R
import com.jinmin.sopt.data.git_repo.GetGitRepoData
import com.jinmin.sopt.data.git_repo.GetGitRepoRepo
import com.jinmin.sopt.data.git_repo.GitRepoRepository
import com.jinmin.sopt.data.git_user.GetGitUserRepo
import com.jinmin.sopt.data.git_user.GetUserData
import com.jinmin.sopt.data.git_user.GitUserRepository
import kotlinx.android.synthetic.main.activity_git_follower.txtUserDescription
import kotlinx.android.synthetic.main.activity_git_follower.txtUserId
import kotlinx.android.synthetic.main.activity_git_follower.txtUserName
import kotlinx.android.synthetic.main.activity_git_repo.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitRepoActivity : AppCompatActivity() {
    private lateinit var adapter: GitRepoAdapter
    private val userRepository: GitUserRepository = GetGitUserRepo()
    private val gitRepoRepository : GitRepoRepository = GetGitRepoRepo()
    private var login = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_git_repo)


        login = intent.getStringExtra("follower_login")
        makeUser(login)
        makeRepo(login)
    }

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

    private fun makeRepo(login: String){
        adapter = GitRepoAdapter(this)
        rvGitList.adapter = adapter
        rvGitList.layoutManager = LinearLayoutManager(this)

        rvGitList.addItemDecoration(object : RecyclerView.ItemDecoration(){
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                outRect.top = 15.dpToPx()
            }
        })
        gitRepoRepository.getRepos(login).enqueue(object : Callback<List<GetGitRepoData>>{
            override fun onFailure(call: Call<List<GetGitRepoData>>, t: Throwable) {
                Log.e("sopt_error_3"," t = $t")
            }

            override fun onResponse(
                call: Call<List<GetGitRepoData>>,
                response: Response<List<GetGitRepoData>>
            ) {
                if(response.isSuccessful){
                    val repos = response.body()!!

                    adapter.data = repos
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
