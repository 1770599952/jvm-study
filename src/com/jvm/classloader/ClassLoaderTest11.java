package com.jvm.classloader;

public class ClassLoaderTest11 {

}

class Test {
    static {
     //   num = 1;                   // 静态代码块可以为处于其之后的静态常量进行赋值
     //   System.out.println(num);   // 但无法非法前向引用，访问操作
    }

    private static int num = 0;
}
