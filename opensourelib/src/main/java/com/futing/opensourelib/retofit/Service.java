package com.futing.opensourelib.retofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by futing on 2024/8/17.
 */
public interface Service {
    @GET("user/{}/")
    Call login();

}
