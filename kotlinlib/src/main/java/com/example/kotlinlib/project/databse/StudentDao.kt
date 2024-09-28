package com.example.kotlinlib.project.databse

import androidx.room.*
import com.example.kotlinlib.project.databse.Student
//2.查询者
//DAO 数据库的访问对象，对数据的增删改查； 注解
@Dao  // Database access object   增删改查
interface StudentDao {

    // vararg 可变参数
    // void a(Student... stus)   vs   vararg students: Student
    @Insert
    fun insertStudents(vararg students: Student)

    @Update
    fun updateStudents(vararg students: Student)

    // 根据条件删除
    @Delete
    fun deleteStudents(vararg students: Student)

    // 删除全部
    @Query("DELETE FROM student")
    fun deleteAllStudents()

    // 查询全部   倒序：ORDER BY ID DESC
    @Query("SELECT * FROM student ORDER BY ID DESC")
    fun queryAllStudents() : List<Student>
}