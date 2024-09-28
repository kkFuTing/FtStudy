package com.example.kotlinlib.project.databse;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/kotlinlib/project/databse/StudentDatabase;", "Landroidx/room/RoomDatabase;", "()V", "getStudentDao", "Lcom/example/kotlinlib/project/databse/StudentDao;", "Companion", "kotlinlib_debug"})
@androidx.room.Database(entities = {com.example.kotlinlib.project.databse.Student.class}, version = 1)
public abstract class StudentDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.Nullable
    private static com.example.kotlinlib.project.databse.StudentDatabase INSTANCE;
    @org.jetbrains.annotations.NotNull
    public static final com.example.kotlinlib.project.databse.StudentDatabase.Companion Companion = null;
    
    public StudentDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public abstract com.example.kotlinlib.project.databse.StudentDao getStudentDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/kotlinlib/project/databse/StudentDatabase$Companion;", "", "()V", "INSTANCE", "Lcom/example/kotlinlib/project/databse/StudentDatabase;", "getDatabase", "context", "Landroid/content/Context;", "kotlinlib_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.example.kotlinlib.project.databse.StudentDatabase getDatabase(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable
        public final com.example.kotlinlib.project.databse.StudentDatabase getDatabase() {
            return null;
        }
    }
}