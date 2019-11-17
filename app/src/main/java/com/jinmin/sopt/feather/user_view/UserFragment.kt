package com.jinmin.sopt.feather.user_view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.jinmin.sopt.R
import com.jinmin.sopt.data.git_user.GetGitUserRepo
import com.jinmin.sopt.data.git_user.GetUserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */

private const val LOGIN : String = ""
class UserFragment : Fragment() {

    private var login : String? = null

    private lateinit var imgUserProfile : ImageView
    private lateinit var txtUserId : TextView
    private lateinit var txtUserName : TextView
    private lateinit var txtUserDescription : TextView

    private val userRepository = GetGitUserRepo()

    //유지하고 하는 데이터나 화면 초기화(여기에서는 로그인 id가 해당)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            login = it.getString(LOGIN).toString()
        }

    }

    //fragment의 화면 설정
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_user, container, false)
        // Inflate the layout for this fragment
        return view
    }

    //fragment가 Activity에 접근!!!! 가장 중요!! 내용 삽입!!
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        view?.let {
            imgUserProfile = it.findViewById(R.id.imgUserProfile)
            txtUserId = it.findViewById(R.id.txtUserId)
            txtUserName = it.findViewById(R.id.txtUserName)
            txtUserDescription = it.findViewById(R.id.txtUserDescription)

            login?.let {
                userRepository.getUser(it).enqueue(object : Callback<GetUserData>{
                    override fun onFailure(call: Call<GetUserData>, t: Throwable) {
                        Log.e("sopt_error_user","t = $t")
                    }

                    override fun onResponse(call: Call<GetUserData>, response: Response<GetUserData>) {
                        if(response.isSuccessful){
                            val user = response.body()!!

                            txtUserId.text = user.login
                            txtUserName.text = user.name
                            txtUserDescription.text = user.bio

                            Glide
                                .with(this@UserFragment)
                                .load(user.avatar_url)
                                .into(imgUserProfile)
                        }
                    }
                })
            }
        }
    }
    companion object {
        @JvmStatic
        fun setLogin(login : String) = UserFragment().apply {
            arguments = Bundle().apply {
                putString(LOGIN, login)
            }
        }
    }
}