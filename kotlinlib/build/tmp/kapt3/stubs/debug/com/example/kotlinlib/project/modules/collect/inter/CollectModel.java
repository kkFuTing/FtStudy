package com.example.kotlinlib.project.modules.collect.inter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH&\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J)\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH&\u00a2\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH&J)\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\"\u00020\bH&\u00a2\u0006\u0002\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/example/kotlinlib/project/modules/collect/inter/CollectModel;", "", "requestDelete", "", "listener", "Lcom/example/kotlinlib/project/modules/collect/inter/CollectPresenter$OnCollectListener;", "students", "", "Lcom/example/kotlinlib/project/databse/Student;", "(Lcom/example/kotlinlib/project/modules/collect/inter/CollectPresenter$OnCollectListener;[Lcom/example/kotlinlib/project/databse/Student;)V", "requestDeleteAll", "requestInsert", "requestQueryAll", "Lcom/example/kotlinlib/project/modules/collect/inter/CollectPresenter$OnCollectResponseListener;", "requestUpdate", "kotlinlib_debug"})
public abstract interface CollectModel {
    
    public abstract void requestInsert(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.modules.collect.inter.CollectPresenter.OnCollectListener listener, @org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.databse.Student... students);
    
    public abstract void requestUpdate(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.modules.collect.inter.CollectPresenter.OnCollectListener listener, @org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.databse.Student... students);
    
    public abstract void requestDelete(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.modules.collect.inter.CollectPresenter.OnCollectListener listener, @org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.databse.Student... students);
    
    public abstract void requestDeleteAll(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.modules.collect.inter.CollectPresenter.OnCollectListener listener);
    
    public abstract void requestQueryAll(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.modules.collect.inter.CollectPresenter.OnCollectResponseListener listener);
}