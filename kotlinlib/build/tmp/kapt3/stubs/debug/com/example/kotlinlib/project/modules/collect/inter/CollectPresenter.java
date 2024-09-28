package com.example.kotlinlib.project.modules.collect.inter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u0002\f\rJ!\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H&\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0003H&J!\u0010\t\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H&\u00a2\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0003H&J!\u0010\u000b\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H&\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/example/kotlinlib/project/modules/collect/inter/CollectPresenter;", "Lcom/example/kotlinlib/project/base/IBasePresenter;", "requestDelete", "", "students", "", "Lcom/example/kotlinlib/project/databse/Student;", "([Lcom/example/kotlinlib/project/databse/Student;)V", "requestDeleteAll", "requestInsert", "requestQueryAll", "requestUpdate", "OnCollectListener", "OnCollectResponseListener", "kotlinlib_debug"})
public abstract interface CollectPresenter extends com.example.kotlinlib.project.base.IBasePresenter {
    
    public abstract void requestInsert(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.databse.Student... students);
    
    public abstract void requestUpdate(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.databse.Student... students);
    
    public abstract void requestDelete(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.databse.Student... students);
    
    public abstract void requestDeleteAll();
    
    public abstract void requestQueryAll();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/kotlinlib/project/modules/collect/inter/CollectPresenter$OnCollectListener;", "", "showIUD", "", "iudResult", "", "kotlinlib_debug"})
    public static abstract interface OnCollectListener {
        
        public abstract void showIUD(boolean iudResult);
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/kotlinlib/project/modules/collect/inter/CollectPresenter$OnCollectResponseListener;", "", "showResultSuccess", "", "result", "", "Lcom/example/kotlinlib/project/databse/Student;", "kotlinlib_debug"})
    public static abstract interface OnCollectResponseListener {
        
        public abstract void showResultSuccess(@org.jetbrains.annotations.Nullable
        java.util.List<com.example.kotlinlib.project.databse.Student> result);
    }
}