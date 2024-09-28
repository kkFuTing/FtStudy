package com.example.kotlinlib.project.modules.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.kotlinlib.project.MainActivity
import com.example.kotlinlib.R
import com.example.kotlinlib.databinding.ActivityUserLoginBinding
import com.example.kotlinlib.project.base.BaseActivity
import com.example.kotlinlib.project.config.Flag
import com.example.kotlinlib.project.entity.LoginRegisterResponse
import com.example.kotlinlib.project.modules.login.inter.LoginPresenter
import com.example.kotlinlib.project.modules.login.inter.LoginView
import com.example.kotlinlib.project.modules.register.RegisterActivity

//import kotlinx.android.synthetic.main.activity_user_login.*

// 违背单一的原则  C  V  M

// MVVM + JetPack

// 登录界面 123456886 ::  123456


// TODO  =========================================   View层  的 实现

class LoginActivity : BaseActivity<LoginPresenter>(), LoginView {

    // lateinit var p: LoginPresenter
    private lateinit var binding: ActivityUserLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_user_login)

        binding = ActivityUserLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hideActionBar()


//        user_login_bt.setOnClickListener(onCLickLister)
        binding.userLoginBt.setOnClickListener(onCLickLister)

        // p = LoginPresenterImpl(this)


//        user_register_tv.setOnClickListener {
        binding.userRegisterTv.setOnClickListener {
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private val onCLickLister = View.OnClickListener { view ->
        // id = 内部根据= 知道你是 要 setId，  否则就是getId
        when (view.id) {
            // 登录
            R.id.user_login_bt -> {

//                val userNameStr = user_phone_et.text.toString()
//                val userPwdStr = user_password_et.text.toString()
                val userNameStr = binding.userPhoneEt.text.toString()
                val userPwdStr = binding.userPasswordEt.text.toString()
                Log.d(Flag.TAG, "userName:$userNameStr,  userPwd:$userPwdStr")

                // 我只需 知道 P层
                presenter.loginAction(this@LoginActivity, userNameStr, userPwdStr)
            }

            // else->
        }
    }

    // 响应的两个函数1
    override fun loginSuccess(loginBean: LoginRegisterResponse?) {
        Toast.makeText(this@LoginActivity, "登录成功😀", Toast.LENGTH_SHORT).show()

        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        startActivity(intent)
    }
    // 响应的两个函数 2
    override fun loginFialure(erroeMsg: String?) {
        Toast.makeText(this@LoginActivity, "登录失败 ~ 呜呜呜$erroeMsg", Toast.LENGTH_SHORT).show()
    }

    //创建presenter
    override fun createP(): LoginPresenter = LoginPresenterImpl(this)

    override fun recycle() {
        presenter.unAttachView()
    }
}
