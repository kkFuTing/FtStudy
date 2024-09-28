package com.example.kotlinlib.objectcase;

/**
 * Created by futing on 2024/8/1.
 * 伴生对象是一个类内部的对象声明，它与该类的实例共享相同的名称。
 * 使用场景：伴生对象适用于在类内部定义静态方法或静态属性，并与类的实例无关的场景。
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/example/kotlinlib/objectcase/NetworkManager;", "", "()V", "Companion", "kotlinlib_debug"})
public final class NetworkManager {
    @org.jetbrains.annotations.NotNull
    public static final com.example.kotlinlib.objectcase.NetworkManager.Companion Companion = null;
    
    public NetworkManager() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/kotlinlib/objectcase/NetworkManager$Companion;", "", "()V", "performRequest", "", "value", "", "kotlinlib_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void performRequest(@org.jetbrains.annotations.NotNull
        java.lang.String value) {
        }
    }
}