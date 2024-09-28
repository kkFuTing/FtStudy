package com.example.kotlinlib.project.entity


/**
 * data 登录成功 需要把这个Bean 给 UI

"data": {
    "admin": false,
    "chapterTops": [],
    "collectIds": [],
    "email": [],
    "icon": "",
    "id": 66720,
    "nickname": "Derry-vip",
    "password": "",
    "publicName": "Derry-vip",
    "token": "",
    "type": 0,
    "username": "Derry-vip"
    }


 */

// 通配符Java?   ====   kt *   （*表示不知道什么类型，通配符）
// String ? 允许服务器字段是 null
data class LoginResponse(val admin: Boolean,
                         val chapterTops: List<*>,
                         val collectIds: List<*>,
                         val email: String ?,
                         val icon: String?,
                         val id: String?,
                         val nickname: String?,
                         val password: String?,
                         val publicName: String?,
                         val token: String?,
                         val type: Int,
                         val username: String?
                         )