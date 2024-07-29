package com.futing.javalib.javabase;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by futing on 2024/6/22.
 */
public class SerializableData {
    public static void main(String[] args) {
        //
        String currentDir = System.getProperty("user.dir");
        System.out.println(currentDir);

        TestBean testBean = new TestBean("a", "b");
        try {
            //在project 根目录下 java_lib_test.txt
            //序列化
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("java_lib_test.txt"));
            os.writeObject(testBean);
            //反序列化
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("java_lib_test.txt"));
            TestBean o = (TestBean) inputStream.readObject();
            System.out.println(o.name);
            System.out.println(o.pwd);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
