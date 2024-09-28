package com.example.kotlinlib.project.modules.register

import android.os.Bundle
import android.widget.Toast
import com.example.kotlinlib.R
import com.example.kotlinlib.databinding.ActivityUserRegisterBinding
import com.example.kotlinlib.project.base.BaseActivity
import com.example.kotlinlib.project.entity.LoginRegisterResponse
import com.example.kotlinlib.project.modules.register.inter.RegisterPersenter
import com.example.kotlinlib.project.modules.register.inter.RegisterView

//import kotlinx.android.synthetic.main.activity_user_register.*

class RegisterActivity : BaseActivity<RegisterPersenter>(), RegisterView {

    private lateinit var binding: ActivityUserRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hideActionBar()

//        setContentView(R.layout.activity_user_register)
        binding = ActivityUserRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)



//        user_register_bt.setOnClickListener {
        binding.userRegisterBt.setOnClickListener {
            //调用注册
//            val usernameStr = user_phone_et.text.toString()
//            val passwordStr = user_password_et.text.toString()
            val usernameStr = binding.userPhoneEt.text.toString()
            val passwordStr = binding.userPasswordEt.text.toString()
            presenter.registerWanAndroid(
                this@RegisterActivity,
                usernameStr,
                passwordStr,
                passwordStr
            )
        }
    }

    override fun createP(): RegisterPersenter = RegisterPresenterImpl(this)

    override fun recycle() {
        presenter.unAttachView()
    }

    override fun registerSuccess(registerBean: LoginRegisterResponse?) {
        Toast.makeText(this, "注册成功😀", Toast.LENGTH_SHORT).show()
    }

    override fun registerFailed(errorMsg: String?) {
        Toast.makeText(this, "注册失败 ~ 呜呜呜$errorMsg", Toast.LENGTH_SHORT).show()
    }
}