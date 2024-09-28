package com.example.kotlinlib.project.modules.collect;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J!\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\"\u00020\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\rH\u0016J!\u0010\u0013\u001a\u00020\r2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\"\u00020\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\rH\u0016J!\u0010\u0015\u001a\u00020\r2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\"\u00020\u0010H\u0016\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\r2\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001bH\u0016J\b\u0010\u001c\u001a\u00020\rH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0006\u00a8\u0006\u001d"}, d2 = {"Lcom/example/kotlinlib/project/modules/collect/CollectPresenterImpl;", "Lcom/example/kotlinlib/project/modules/collect/inter/CollectPresenter;", "Lcom/example/kotlinlib/project/modules/collect/inter/CollectPresenter$OnCollectListener;", "Lcom/example/kotlinlib/project/modules/collect/inter/CollectPresenter$OnCollectResponseListener;", "view", "Lcom/example/kotlinlib/project/modules/collect/inter/CollectView;", "(Lcom/example/kotlinlib/project/modules/collect/inter/CollectView;)V", "modele", "Lcom/example/kotlinlib/project/modules/collect/inter/CollectModel;", "getView", "()Lcom/example/kotlinlib/project/modules/collect/inter/CollectView;", "setView", "requestDelete", "", "students", "", "Lcom/example/kotlinlib/project/databse/Student;", "([Lcom/example/kotlinlib/project/databse/Student;)V", "requestDeleteAll", "requestInsert", "requestQueryAll", "requestUpdate", "showIUD", "iudResult", "", "showResultSuccess", "result", "", "unAttachView", "kotlinlib_debug"})
public final class CollectPresenterImpl implements com.example.kotlinlib.project.modules.collect.inter.CollectPresenter, com.example.kotlinlib.project.modules.collect.inter.CollectPresenter.OnCollectListener, com.example.kotlinlib.project.modules.collect.inter.CollectPresenter.OnCollectResponseListener {
    @org.jetbrains.annotations.Nullable
    private com.example.kotlinlib.project.modules.collect.inter.CollectView view;
    @org.jetbrains.annotations.NotNull
    private final com.example.kotlinlib.project.modules.collect.inter.CollectModel modele = null;
    
    public CollectPresenterImpl(@org.jetbrains.annotations.Nullable
    com.example.kotlinlib.project.modules.collect.inter.CollectView view) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.example.kotlinlib.project.modules.collect.inter.CollectView getView() {
        return null;
    }
    
    public final void setView(@org.jetbrains.annotations.Nullable
    com.example.kotlinlib.project.modules.collect.inter.CollectView p0) {
    }
    
    @java.lang.Override
    public void requestInsert(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.databse.Student... students) {
    }
    
    @java.lang.Override
    public void requestUpdate(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.databse.Student... students) {
    }
    
    @java.lang.Override
    public void requestDelete(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.databse.Student... students) {
    }
    
    @java.lang.Override
    public void requestDeleteAll() {
    }
    
    @java.lang.Override
    public void requestQueryAll() {
    }
    
    @java.lang.Override
    public void unAttachView() {
    }
    
    @java.lang.Override
    public void showResultSuccess(@org.jetbrains.annotations.Nullable
    java.util.List<com.example.kotlinlib.project.databse.Student> result) {
    }
    
    @java.lang.Override
    public void showIUD(boolean iudResult) {
    }
}