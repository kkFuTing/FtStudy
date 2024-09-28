package com.futing.opensourelib.retrofit;

import android.view.View;

import com.futing.opensourelib.retrofit.Retrofit;
import com.futing.opensourelib.retrofit.http.Filed;
import com.futing.opensourelib.retrofit.http.GET;
import com.futing.opensourelib.retrofit.http.POST;
import com.futing.opensourelib.retrofit.http.Query;

import org.junit.Test;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static org.junit.Assert.*;

// TODO: 2024/9/4  t这是自己很久就实现的！！！
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class RetrofitUnitTest {

    interface Weather{

        @GET("/v3/weather/weatherInfo")
        Call get(@Query("city")String city,@Query("key")String key);

        @POST("/v3/weather/weatherInfo")
        Call post(@Filed("city") String city, @Filed("key")String key);
    }


    @Test
    public void testRetrofit(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://restapi.amap.com/").build();
        Weather weather = retrofit.create(Weather.class);
        Call call = weather.post("长沙","13cb58f5884f9749287abbead9c658f2");
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  /*  public void post(View view) {
        RequestBody body = new RequestBody()
                .add("city", "长沙")
                .add("key", "13cb58f5884f9749287abbead9c658f2");
        Request request = new Request.Builder().url("http://restapi.amap" +
                ".com/v3/weather/weatherInfo").post(body).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                Log.e("响应体", response.getBody());
            }
        });
    }*/
}