package com.example.kotlinlib.project.modules.collect;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0016\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J)\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0016\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000eH\u0016J)\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0016\u00a2\u0006\u0002\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lcom/example/kotlinlib/project/modules/collect/CollectModuleImpl;", "Lcom/example/kotlinlib/project/modules/collect/inter/CollectModel;", "()V", "requestDelete", "", "listener", "Lcom/example/kotlinlib/project/modules/collect/inter/CollectPresenter$OnCollectListener;", "students", "", "Lcom/example/kotlinlib/project/databse/Student;", "(Lcom/example/kotlinlib/project/modules/collect/inter/CollectPresenter$OnCollectListener;[Lcom/example/kotlinlib/project/databse/Student;)V", "requestDeleteAll", "requestInsert", "requestQueryAll", "Lcom/example/kotlinlib/project/modules/collect/inter/CollectPresenter$OnCollectResponseListener;", "requestUpdate", "kotlinlib_debug"})
public final class CollectModuleImpl implements com.example.kotlinlib.project.modules.collect.inter.CollectModel {
    
    public CollectModuleImpl() {
        super();
    }
    
    @java.lang.Override
    public void requestInsert(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.modules.collect.inter.CollectPresenter.OnCollectListener listener, @org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.databse.Student... students) {
    }
    
    @java.lang.Override
    public void requestUpdate(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.modules.collect.inter.CollectPresenter.OnCollectListener listener, @org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.databse.Student... students) {
    }
    
    @java.lang.Override
    public void requestDelete(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.modules.collect.inter.CollectPresenter.OnCollectListener listener, @org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.databse.Student... students) {
    }
    
    @java.lang.Override
    public void requestDeleteAll(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.modules.collect.inter.CollectPresenter.OnCollectListener listener) {
    }
    
    @java.lang.Override
    public void requestQueryAll(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.modules.collect.inter.CollectPresenter.OnCollectResponseListener listener) {
    }
}