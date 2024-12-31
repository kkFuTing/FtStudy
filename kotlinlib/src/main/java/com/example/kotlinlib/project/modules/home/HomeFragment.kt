package com.example.kotlinlib.project.modules.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.kotlinlib.R
import com.example.kotlinlib.databinding.FragmentHomeBinding
import com.google.gson.Gson
import com.example.kotlinlib.project.DetailLinkActivity
import com.example.kotlinlib.project.adapter.HomeInfoListAdapter
import com.example.kotlinlib.project.config.Flag
import com.example.kotlinlib.project.data_model.request.NetworkResultData
import com.example.kotlinlib.project.data_model.request.RequestAPI
import com.example.kotlinlib.project.entity.HomeDataResponse
//import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.Response

/**
 * 同学们这是：首页的Fragment
 *
 * 使用的mvc
 */
class HomeFragment : Fragment() {
    private lateinit var homeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Toast.makeText(activity, "首页", Toast.LENGTH_SHORT).show()
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.rootView
//        val root: View? = inflater.inflate(R.layout.fragment_home, container, false) //  null
//        return root ?: super.onCreateView(inflater, container, savedInstanceState)
    }

    init {
        setHasOptionsMenu(true);
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.personal_menu, menu)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        requestHomeData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // phongGap
//        iv_top.setOnClickListener {

        homeBinding.ivTop.setOnClickListener {
            val intent: Intent = Intent(activity, DetailLinkActivity::class.java)
            intent.putExtra(Flag.URL_KEY, linkPath1)
            startActivity(intent)
        }

//        iv_bottom.setOnClickListener {
        homeBinding.ivBottom.setOnClickListener {
            val intent: Intent = Intent(activity, DetailLinkActivity::class.java)
            intent.putExtra(Flag.URL_KEY, linkPath2)
            startActivity(intent)
        }
    }

    /**
     * 请求首页的数据集
     */
    private fun requestHomeData() {
        RequestAPI.instanceRequestAction(Flag.SERVER_URL, "1", object : NetworkResultData() {

            // 失败 main 已经NetworkResultData切换过来了
            override fun requestError(info: String) {
                Log.e(Flag.TAG, "requestHomeData requestError info:$info")
                showResultError(info)
            }

            // 成功 main 已经NetworkResultData切换过来了
            override fun reqeustSuccess(result: Response) {
                // gons   json  ---> bean
                try {
                    val resultData = result.body?.string().toString()
                    Log.e(
                        Flag.TAG,
                        "成功  数据在response里面  获取后台给我们的JSON 字符串 resultData:$resultData"
                    )

                    // Gson解析成可操作的对象
                    val gson = Gson()
                    val homeDataResponse: HomeDataResponse =
                        gson.fromJson(resultData, HomeDataResponse::class.java)
                    showResultSuccess(homeDataResponse)
                } catch (e: Exception) {
                    e.printStackTrace()

                    Log.e(Flag.TAG, "requestSuccess 解析数据时Exception:${e.message}")
                }
            }

        })
    }

    private lateinit var linkPath1: String
    private lateinit var linkPath2: String

    /**
     * TODO 首页的画面展示【成功】
     */
    private fun showResultSuccess(result: HomeDataResponse) {
//        text_home.text = "欢迎同学们的到来>>>>>>>>>>>"
        homeBinding.textHome.text = "欢迎同学们的到来>>>>>>>>>>>"

        //不考虑为null的写法
        // home_listview.adapter = HomeInfoListAdapter(context!!, result.data.news_list)
        //考虑为null的写法
        homeBinding.homeListview.adapter =
            context?.myRun { HomeInfoListAdapter(it, result.data.news_list) }

//        context.run {  } //发现要用这个哈哈哈， 这个是myRun自己写的!!!!

        // TODO: 2024.8.23 z这里我自己写的，我觉得上一句应该是等同这一句的，不为空才去执行
//        homeBinding.homeListview.adapter =
//            context?.let { HomeInfoListAdapter(it, result.data.news_list) }

        // 两者图片的显示
//        Glide.with(iv_top).load(result.data.company_list[0].image).into(iv_top)
//        Glide.with(iv_bottom).load(result.data.ad_list[0].image).into(iv_bottom)
        Glide.with(homeBinding.ivTop).load(result.data.company_list[0].image)
            .into(homeBinding.ivTop)
        Glide.with(homeBinding.ivBottom).load(result.data.ad_list[0].image)
            .into(homeBinding.ivBottom)

        // WebView需要加载的URL 链接  两个 两张图片
        linkPath1 = result.data.company_list[0].link
        linkPath2 = result.data.ad_list[0].link
    }

    /**
     * TODO 首页的画面展示【失败】
     */
    private fun showResultError(errorMsg: String) {
        Toast.makeText(activity, "首页数据请求失败: errorMsg:$errorMsg", Toast.LENGTH_SHORT).show()
    }
}

fun <T, R> T.myRun(m: (T) -> R): R = m(this)  // 调用高阶函数
