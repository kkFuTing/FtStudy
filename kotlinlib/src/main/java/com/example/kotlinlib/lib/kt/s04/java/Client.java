package com.example.kotlinlib.lib.kt.s04.java;

import java.io.File;
import java.io.FileReader;
import kotlin.io.FilesKt;
import kotlin.text.Charsets;

public class Client {

    void test() {
        File file = new File("xxxx");

        // Java 调用 扩展函数   Charsets.UTF_8这必须传在，kotlin不用是因为默认传了；
        FilesKt.readText(file, Charsets.UTF_8);

    }

}
