package com.example.kotlinlib.project.modules.collect.inter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/example/kotlinlib/project/modules/collect/inter/CollectView;", "", "showResult", "", "result", "", "showResultSuccess", "", "Lcom/example/kotlinlib/project/databse/Student;", "kotlinlib_debug"})
public abstract interface CollectView {
    
    public abstract void showResultSuccess(@org.jetbrains.annotations.Nullable
    java.util.List<com.example.kotlinlib.project.databse.Student> result);
    
    public abstract void showResult(boolean result);
}