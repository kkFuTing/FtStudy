package com.example.kotlinlib.ubt

import com.bumptech.glide.disklrucache.DiskLruCache.Value

/**
 * Created by ting.fu on 2024/12/23.
 */
fun main() {

   val webSocketManager = Websocket(
//            url = "wss:/api-gai.sensetime.com/temp-demo/4e161458-jwt", // 替换为实际的 WebSocket URL
//            url = "https://api-gai.sensetime.com/temp-demo/4e161458-jwt/", // 替换为实际的 WebSocket URL
        url = "wss://api-gai.sensetime.com/temp-demo/4e161458-jwt/ws", // 替换为实际的 WebSocket URL
//            url = "wss://api-gai.sensetime.com/temp-demo/4e161458-jwt/ws", // 替换为实际的 WebSocket URL
        jwtToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJ5b3ViaXh1YW4tand0LTIwMjQxMjA2IiwiZXhwIjoxNzM0Njk4NjY0LCJuYmYiOjE3MzQ2MTIyNTR9.cOHw7DHkSXal0bcJD3bU6RwjsJHKvmLbRAAshBqQwvA",
        vadNegThreshold = 100,
        vadPosThreshold = 200,
        vadMinSpeechDurationMs = 1500,
        vadMinSilenceDurationMs = 1000,
        systemPrompt = "通用女生：你的名字叫小优，你是一个年轻女生，你的性格友善，充满阳光与正能量。你说话清新自然，言语间透着细腻和体贴，总能以舒缓而愉悦的方式与人交流，让人感到放松和愉快。"
    )
    val url =
        "wss://api-gai.sensetime.com/temp-demo/4e161458-jwt/ws?audio_only=true&vad_neg_threshold=0.5&vad_pos_threshold=0.98&vad_min_speech_duration_ms=400&vad_min_silence_duration_ms=800&" +
                "systemPrompt=通用女生：你的名字叫小优，你是一个年轻女生，你的性格友善，充满阳光与正能量。你说话清新自然，言语间透着细腻和体贴，总能以舒缓而愉悦的方式与人交流，让人感到放松和愉快。&" +
                "jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJ5b3ViaXh1YW4tand0LTIwMjQxMjA2IiwiZXhwIjoxNzM1MDA3NzUzLCJuYmYiOjE3MzQ5MjEzNDN9.71f1mtpk3kHfq24MaLmGX0Pu0GD17c7mdFaiSGG2Knw"
    webSocketManager.connect()
}