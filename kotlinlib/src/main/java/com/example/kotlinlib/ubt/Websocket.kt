package com.example.kotlinlib.ubt

import okhttp3.HttpUrl


/**
 * Created by ting.fu on 2024/12/23.
 */
class Websocket(
    private val url: String,
    private val jwtToken: String,
    private val vadNegThreshold: Int,
    private val vadPosThreshold: Int,
    private val vadMinSpeechDurationMs: Int,
    private val vadMinSilenceDurationMs: Int,
    private val systemPrompt: String?
) {

    fun connect() {
//        val urlBuilder = url.toHttpUrlOrNull()?.newBuilder()?.apply {
//            addQueryParameter("jwt", jwtToken)
//            addQueryParameter("vad_neg_threshold", vadNegThreshold.toString())
//            addQueryParameter("vad_pos_threshold", vadPosThreshold.toString())
//            addQueryParameter("vad_min_speech_duration_ms", vadMinSpeechDurationMs.toString())
//            addQueryParameter("vad_min_silence_duration_ms", vadMinSilenceDurationMs.toString())
//            systemPrompt?.let { addQueryParameter("system_prompt", it) }
//        }
//        val finalUrl = urlBuilder?.build().toString()
//        println(finalUrl)
    }
}