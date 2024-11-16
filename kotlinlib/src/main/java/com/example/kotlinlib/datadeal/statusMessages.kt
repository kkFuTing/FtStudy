fun main() {
    val statusMessages: Map<String, String> = mapOf(
//                    "hello_response" to "嘿，我是小优呀！以后我可以陪你聊天解闷，在你找东西时帮你快速识别图像，还能在你有疑问时给你提供各种知识。 而且我还有体温，身体也很灵活哦，能帮你做不少事呢！ 现在，下载“U世界”App帮我联网，让我更好的为你服务吧。",
//                    "hello_response" to "蓝牙连接成功，蓝牙已断开，音箱连接失败，已连接音箱，WIFI密码错误，WIFI连接失败，WIFI连接成功,当前网络异常，请检查后再试,请先连接网络,无法连接到服务器，请稍后再试,电量低，请充电。",
//                    "hello_response" to "正在进行系统升级，请勿关机。 有人吗？  嗯？ 角色属性修改失败。 舵机异常，可能影响使用。 即将关机，下次见。 请到我面前。请在手机App中输入你的信息。 已完成人脸信息注册。 舵机异常保护，请重启机器人。 舵机调度超出限位，请检查设,请不要这样。"
//                    "bluetooth_connected" to "蓝牙连接成功。"
        //                    ,
//                    "bluetooth_disconnected" to "蓝牙已断开。",
//                    "speaker_connection_failed" to "音箱连接失败。",
//                    "speaker_connected" to "已连接音箱。",
//                    "wifi_password_error" to "WIFI密码错误。",
//                    "wifi_connection_failed" to "WIFI连接失败。",
//                    "wifi_connected" to "WIFI连接成功。",
//                    "network_error" to "当前网络异常，请检查后再试。",
//                    "please_connect_network" to "请先连接网络。",
//                    "server_connection_failed" to "无法连接到服务器，请稍后再试。",
//                    "low_battery" to "电量低，请充电。",
//                    "system_upgrade" to "正在进行系统升级，请勿关机。",
//                    "hello_question" to "有人吗？",
//                    "hello_response" to "嘿，我是小优呀！",
//                    "question_sound" to "嗯？",
//                    "thinking_sound" to "嗯……",
//                    "role_update_failed" to "角色属性修改失败。",
//                    "servo_error" to "舵机异常，可能影响使用。",
//                    "shutdown_message" to "即将关机，下次见。",
//                    "come_here_command" to "请到我面前。",
//                    "enter_info_prompt" to "请在手机App中输入你的信息。",
//                    "face_registration_complete" to "已完成人脸信息注册。",
//                    "servo_protection" to "舵机异常保护，请重启机器人。",
//                    "servo_limit_error" to "舵机调度超出限位，请检查设0。",
//                    "please_do_not" to "请不要这样。"
    )

    // 定义一个包含所有值的列表
    val values = listOf(
        "蓝牙连接成功。",
        "蓝牙已断开。",
        "音箱连接失败。",
        "已连接音箱。",
        "WIFI密码错误。",
        "WIFI连接失败。",
        "WIFI连接成功。",
        "当前网络异常，请检查后再试。",
        "请先连接网络。",
        "无法连接到服务器，请稍后再试。",
        "电量低，请充电。",
        "正在进行系统升级，请勿关机。",
        "有人吗？",
//        "嘿，我是小优呀！以后我可以陪你聊天解闷，在你找东西时帮你快速识别图像，还能在你有疑问时给你提供各种知识。而且我还有体温，身体也很灵活哦，能帮你做不少事呢！现在，下载“U世界”App帮我联网，让我更好的为你服务吧。",
        "嘿，我是小优呀",
        "嗯？",
        "嗯……",
        "角色属性修改失败。",
        "舵机异常，可能影响使用。",
        "即将关机，下次见。",
        "请到我面前。",
        "请在手机App中输入你的信息。",
        "已完成人脸信息注册。",
        "舵机异常保护，请重启机器人。",
        "舵机调度超出限位，请检查设0。",
        "请不要这样。"
    )
}