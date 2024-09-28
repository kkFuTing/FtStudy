package com.example.kotlinlib.objectcase;

/**
 * Created by futing on 2024/8/1.
 *
 * bject 关键字是一个强大且灵活的工具，它提供了对象声明、伴生对象和对象表达式三种不同的使用方式。
 *
 * 对象声明是 Object 关键字的一种用法，它允许我们创建一个单例对象，同时可以定义属性、方法和初始化逻辑。对象声明适用于以下场景：
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/kotlinlib/objectcase/DataManager;", "", "()V", "data", "", "", "addData", "", "item", "getData", "", "kotlinlib_debug"})
public final class DataManager {
    @org.jetbrains.annotations.NotNull
    private static final java.util.List<java.lang.String> data = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.kotlinlib.objectcase.DataManager INSTANCE = null;
    
    private DataManager() {
        super();
    }
    
    public final void addData(@org.jetbrains.annotations.NotNull
    java.lang.String item) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getData() {
        return null;
    }
}