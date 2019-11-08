package com.jinmin.sopt.sign_up

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.jinmin.sopt.R
import com.jinmin.sopt.sign_in.SignInActivity
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnSignUp.setOnClickListener {
            val name = txtSignUpName.text.toString()
            val id = txtSignUpId.text.toString()
            val pw = txtSignUpPassword.text.toString()
            val pwck = txtSignUpPwCk.text.toString()

            if(name.isEmpty() || id.isEmpty() || pw.isEmpty() || pwck.isEmpty()){
                Toast.makeText(this,"정보들을 빠짐없이 입력해주세요 !", Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("id",id)
                intent.putExtra("pw",pw)
                setResult(Activity.RESULT_OK,intent)
                finish()
            }
        }
    }
}
