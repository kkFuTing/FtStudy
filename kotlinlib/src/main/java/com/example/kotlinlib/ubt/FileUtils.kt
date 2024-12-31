package com.example.kotlinlib.ubt

import com.example.kotlinlib.project.MyApplication
import java.io.File

/**
 * Created by ting.fu on 2024/11/23.
 */
class FileUtils {
    private fun deleteAudioDir() {
        val fileDir = File("/data/data/com.mysoft.ft/image/")
        fileDir.takeIf { it.exists() }?.delete()
    }

}