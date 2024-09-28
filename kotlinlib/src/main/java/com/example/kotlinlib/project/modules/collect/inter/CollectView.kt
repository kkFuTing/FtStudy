package com.example.kotlinlib.project.modules.collect.inter

import com.example.kotlinlib.project.databse.Student

interface CollectView {

    // 显示数据  --- 》 View

    fun showResultSuccess(result: List<Student> ?)

    fun showResult(result: Boolean)
}