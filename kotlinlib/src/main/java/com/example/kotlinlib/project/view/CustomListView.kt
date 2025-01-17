package com.example.kotlinlib.project.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ListView

class CustomListView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) :

/*{

    // 传递一个 也能帮你掉i用 三个参数的构造函数
    CustomListView(this)

}*/

    ListView(context, attrs, defStyleAttr) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {


        // 测量高度   解决显示不全问题（16 网络复杂的） scrollview+listview 但是recycleView不会遇到这个问题
        // Java
        // int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);

        // KT
        // shl(bits) – 左移位 (Java’s <<)
        // shr(bits) – 右移位 (Java’s >>)
        val expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE shr (2), MeasureSpec.AT_MOST)

        super.onMeasure(widthMeasureSpec, expandSpec)
    }
}