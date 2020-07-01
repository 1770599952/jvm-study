package com.jvm.classloader;

/**
 * 被动引用
 *
 * final static 常量在编译阶段会放入调用类的常量池中，本质上没有直接引用到定义常量的类，因此不会触发定义常量类的初始化。
 */
public class ClassLoaderTest07 {

    public static void main(String[] args) {
        System.out.println(ConstClass.HELLO_WORLD);
    }

}

class ConstClass {
    static {
        System.out.println("静态代码块初始化！");
    }

    public static final String HELLO_WORLD = "hello world";
}