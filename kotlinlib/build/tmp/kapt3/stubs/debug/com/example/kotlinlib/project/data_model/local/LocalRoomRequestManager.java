package com.example.kotlinlib.project.data_model.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u00012\u00020\u0002:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J!\u0010\f\u001a\u00020\u000b2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0016\u00a2\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\u00020\u000b2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0016\u00a2\u0006\u0002\u0010\u0010J\u0010\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0013H\u0016J!\u0010\u0014\u001a\u00020\u000b2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0\u000e\"\u00020\u000fH\u0016\u00a2\u0006\u0002\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u0016"}, d2 = {"Lcom/example/kotlinlib/project/data_model/local/LocalRoomRequestManager;", "Lcom/example/kotlinlib/project/data_model/local/ILocalRequest;", "Lcom/example/kotlinlib/project/data_model/local/IDatabaseRequest;", "()V", "studentDao", "Lcom/example/kotlinlib/project/databse/StudentDao;", "getStudentDao", "()Lcom/example/kotlinlib/project/databse/StudentDao;", "setStudentDao", "(Lcom/example/kotlinlib/project/databse/StudentDao;)V", "deleteAllStudent", "", "deleteStudents", "students", "", "Lcom/example/kotlinlib/project/databse/Student;", "([Lcom/example/kotlinlib/project/databse/Student;)V", "insertStudents", "queryAllStudent", "", "updateStudents", "Companion", "kotlinlib_debug"})
public final class LocalRoomRequestManager implements com.example.kotlinlib.project.data_model.local.ILocalRequest, com.example.kotlinlib.project.data_model.local.IDatabaseRequest {
    
    /**
     * TODO ********************** 下面这一系列都是 本地相关的
     */
    @org.jetbrains.annotations.Nullable
    private com.example.kotlinlib.project.databse.StudentDao studentDao;
    @org.jetbrains.annotations.Nullable
    private static com.example.kotlinlib.project.data_model.local.LocalRoomRequestManager INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.example.kotlinlib.project.data_model.local.LocalRoomRequestManager.Companion Companion = null;
    
    public LocalRoomRequestManager() {
        super();
    }
    
    /**
     * TODO ********************** 下面这一系列都是 本地相关的
     */
    @org.jetbrains.annotations.Nullable
    public final com.example.kotlinlib.project.databse.StudentDao getStudentDao() {
        return null;
    }
    
    /**
     * TODO ********************** 下面这一系列都是 本地相关的
     */
    public final void setStudentDao(@org.jetbrains.annotations.Nullable
    com.example.kotlinlib.project.databse.StudentDao p0) {
    }
    
    @java.lang.Override
    public void insertStudents(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.databse.Student... students) {
    }
    
    @java.lang.Override
    public void updateStudents(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.databse.Student... students) {
    }
    
    @java.lang.Override
    public void deleteStudents(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.databse.Student... students) {
    }
    
    @java.lang.Override
    public void deleteAllStudent() {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.util.List<com.example.kotlinlib.project.databse.Student> queryAllStudent() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/example/kotlinlib/project/data_model/local/LocalRoomRequestManager$Companion;", "", "()V", "INSTANCE", "Lcom/example/kotlinlib/project/data_model/local/LocalRoomRequestManager;", "getINSTANCE", "()Lcom/example/kotlinlib/project/data_model/local/LocalRoomRequestManager;", "setINSTANCE", "(Lcom/example/kotlinlib/project/data_model/local/LocalRoomRequestManager;)V", "getInstance", "kotlinlib_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.example.kotlinlib.project.data_model.local.LocalRoomRequestManager getINSTANCE() {
            return null;
        }
        
        public final void setINSTANCE(@org.jetbrains.annotations.Nullable
        com.example.kotlinlib.project.data_model.local.LocalRoomRequestManager p0) {
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.kotlinlib.project.data_model.local.LocalRoomRequestManager getInstance() {
            return null;
        }
    }
}