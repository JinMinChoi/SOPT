package com.jinmin.sopt.feather.sign_in

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jinmin.sopt.R
import com.jinmin.sopt.data.Login
import com.jinmin.sopt.feather.git_follower.GitFollowerActivity
import com.jinmin.sopt.feather.sign_up.SignUpActivity
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    private val rCode = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        val id = Login.getUser(this)
        if(id.isNotEmpty()){
            goToNext(id)
            finish()
        }

        btnTouch()

    }
    private fun btnTouch(){
        btnSignInLogin.setOnClickListener {
            val id = txtSignInId.text.toString()
            val pw = txtSignInPassword.text.toString()

            if(id.isEmpty() || pw.isEmpty()){
                Toast.makeText(this,"아이디나 비밀번호를 입력해주세요 !",Toast.LENGTH_LONG).show()
            }
            else{
                Login.setUser(this, id)
                goToNext(id)
                //Toast.makeText(this,"로그인 성공 !",Toast.LENGTH_LONG).show()
            }
        }

        btnSignInSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivityForResult(intent, rCode)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == rCode){
            if(resultCode == Activity.RESULT_OK){
                txtSignInId.setText(data!!.getStringExtra("id"))
                txtSignInPassword.setText(data!!.getStringExtra("pw"))
            }
        }
    }

    private fun goToNext(id : String){
        val intent = Intent(this, GitFollowerActivity::class.java)
        intent.putExtra("login",id)
        startActivity(intent)
    }
}
