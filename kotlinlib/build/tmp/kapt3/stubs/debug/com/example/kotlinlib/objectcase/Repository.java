package com.example.kotlinlib.objectcase;

/**
 * Created by futing on 2024/8/1.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/kotlinlib/objectcase/Repository;", "", "()V", "formattedUserNames", "", "", "getFormattedUserNames", "()Ljava/util/List;", "users", "", "Lcom/example/kotlinlib/objectcase/User;", "getUser", "Companion", "kotlinlib_debug"})
public final class Repository {
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.example.kotlinlib.objectcase.User> users = null;
    @org.jetbrains.annotations.Nullable
    private static com.example.kotlinlib.objectcase.Repository INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.example.kotlinlib.objectcase.Repository.Companion Companion = null;
    
    private Repository() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getFormattedUserNames() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.util.List<com.example.kotlinlib.objectcase.User> getUser() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/example/kotlinlib/objectcase/Repository$Companion;", "", "()V", "INSTANCE", "Lcom/example/kotlinlib/objectcase/Repository;", "instance", "getInstance", "()Lcom/example/kotlinlib/objectcase/Repository;", "kotlinlib_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.example.kotlinlib.objectcase.Repository getInstance() {
            return null;
        }
    }
}