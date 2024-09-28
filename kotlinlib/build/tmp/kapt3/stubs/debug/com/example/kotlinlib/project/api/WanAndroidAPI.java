package com.example.kotlinlib.project.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H\'J2\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\n\u001a\u00020\u0007H\'\u00a8\u0006\u000b"}, d2 = {"Lcom/example/kotlinlib/project/api/WanAndroidAPI;", "", "loginAction", "Lio/reactivex/Observable;", "Lcom/example/kotlinlib/project/entity/LoginRegisterResponseWrapper;", "Lcom/example/kotlinlib/project/entity/LoginRegisterResponse;", "username", "", "password", "registerAction", "repassword", "kotlinlib_debug"})
public abstract interface WanAndroidAPI {
    
    /**
     * 登录API
     * username=Derry-vip&password=123456
     */
    @retrofit2.http.POST(value = "/user/login")
    @retrofit2.http.FormUrlEncoded
    @org.jetbrains.annotations.NotNull
    public abstract io.reactivex.Observable<com.example.kotlinlib.project.entity.LoginRegisterResponseWrapper<com.example.kotlinlib.project.entity.LoginRegisterResponse>> loginAction(@retrofit2.http.Field(value = "username")
    @org.jetbrains.annotations.NotNull
    java.lang.String username, @retrofit2.http.Field(value = "password")
    @org.jetbrains.annotations.NotNull
    java.lang.String password);
    
    /**
     * 注册的API
     */
    @retrofit2.http.POST(value = "/user/register")
    @retrofit2.http.FormUrlEncoded
    @org.jetbrains.annotations.NotNull
    public abstract io.reactivex.Observable<com.example.kotlinlib.project.entity.LoginRegisterResponseWrapper<com.example.kotlinlib.project.entity.LoginRegisterResponse>> registerAction(@retrofit2.http.Field(value = "username")
    @org.jetbrains.annotations.NotNull
    java.lang.String username, @retrofit2.http.Field(value = "password")
    @org.jetbrains.annotations.NotNull
    java.lang.String password, @retrofit2.http.Field(value = "repassword")
    @org.jetbrains.annotations.NotNull
    java.lang.String repassword);
}