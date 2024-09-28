package com.futing.memorylib

import android.content.Context
import android.os.Debug
import android.widget.Toast
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date

/**
 * Created by futing on 2024/8/14.
 */
object UtilsK {
    fun createDumpFile(context: Context): Boolean {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd_HH.mm.ssss")
        val createTime = dateFormat.format(Date(System.currentTimeMillis()))
        val cacheDir = context.cacheDir
        val path = cacheDir.absolutePath + "/" + createTime + ".hprof"

        try {
            Debug.dumpHprofData(path)
        } catch (e: IOException) {
            e.printStackTrace()
            return false
        }

        return true
    }

    fun show(context: Context?, result: Boolean) {
        if (result) {
            Toast.makeText(context, "成功", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "失败", Toast.LENGTH_SHORT).show()
        }
    }
}
