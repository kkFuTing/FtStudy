package simple05.s02;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lsimple05/s02/Person;", "Lsimple05/s02/Callback;", "Lsimple05/s02/Callback2;", "()V", "getLayoutID", "", "initView", "", "kotlinlib_debug"})
public abstract class Person implements simple05.s02.Callback, simple05.s02.Callback2 {
    
    public Person() {
        super();
    }
    
    public abstract int getLayoutID();
    
    public abstract void initView();
}