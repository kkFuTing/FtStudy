package com.futing.opensourelib.designpattern.observer_model

/**
 * Created by futing on 2024/8/18.
 * 标准的观察者模式
 */
fun main() {
    test()
}

private fun test() {

    val server = WechatServerObservable()

    val futing = UserPerson("付婷")
    val ft2 = UserPerson("付婷1")
    val ft3 = UserPerson("付婷3")
    val ft4 = UserPerson("付婷4")

    server.addObServer(futing)
    server.addObServer(ft2)
    server.addObServer(ft3)
    server.addObServer(ft4)

    var mes = "重大消息"

    server.pushMessage(mes)
}