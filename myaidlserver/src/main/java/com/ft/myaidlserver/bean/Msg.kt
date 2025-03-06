package com.ft.myaidlserver.bean

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by ting.fu on 2025/3/6.
 */
@Parcelize
data class Msg(val name:String) : Parcelable
