package com.futing.myjetpack.roomdemo01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.futing.myjetpack.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //无所谓layout
        setContentView(R.layout.activity_name);

        //数据库的操作应该是在子线程
        DbTest t=new DbTest();
        t.start();
    }

    public class DbTest extends Thread{
        @Override
        public void run() {
            //使用room步骤五： 开始使用了
            //数据库的操作都在这里进行
            AppDatabase jettDB= Room.databaseBuilder(getApplicationContext()
                            ,AppDatabase.class
                            ,"jettDB").build();
            StudentDao dao=jettDB.userDao();
            dao.insert(new Student("jett","123",1));
            dao.insert(new Student("jett1","123",2));
            dao.insert(new Student("jett2","123",3));
            dao.insert(new Student("jett3","123",4));

            List<Student> list=dao.getAll();
            Log.i("jett",list.toString());

            Student jett2=dao.findByName("jett3");
            Log.i("jett",jett2.toString());
            List<Student> allId=dao.getAllId(new int[]{2,3,4});
            Log.i("jett",allId.toString());

            List<StudentTuple> record=dao.getRecord();
            Log.i("jett",record.toString());
        }
    }

}