package com.example.kotlinlib.project.databse;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J!\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\'\u00a2\u0006\u0002\u0010\bJ!\u0010\t\u001a\u00020\u00032\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\'\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\'J!\u0010\f\u001a\u00020\u00032\u0012\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\'\u00a2\u0006\u0002\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/example/kotlinlib/project/databse/StudentDao;", "", "deleteAllStudents", "", "deleteStudents", "students", "", "Lcom/example/kotlinlib/project/databse/Student;", "([Lcom/example/kotlinlib/project/databse/Student;)V", "insertStudents", "queryAllStudents", "", "updateStudents", "kotlinlib_debug"})
@androidx.room.Dao
public abstract interface StudentDao {
    
    @androidx.room.Insert
    public abstract void insertStudents(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.databse.Student... students);
    
    @androidx.room.Update
    public abstract void updateStudents(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.databse.Student... students);
    
    @androidx.room.Delete
    public abstract void deleteStudents(@org.jetbrains.annotations.NotNull
    com.example.kotlinlib.project.databse.Student... students);
    
    @androidx.room.Query(value = "DELETE FROM student")
    public abstract void deleteAllStudents();
    
    @androidx.room.Query(value = "SELECT * FROM student ORDER BY ID DESC")
    @org.jetbrains.annotations.NotNull
    public abstract java.util.List<com.example.kotlinlib.project.databse.Student> queryAllStudents();
}