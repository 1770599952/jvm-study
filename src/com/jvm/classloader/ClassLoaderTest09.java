package com.jvm.classloader;

/**
 * 被动引用
 * <p>
 * 通过子类调用父类的静态属性，不会触发子类自身的加载
 */
public class ClassLoaderTest09 {
    public static void main(String[] args) {
        System.out.println(SonClass.STATIC_FIELD);
    }
}

class SuperClass {
    public static String STATIC_FIELD = "HELLO MI ZHI JIA";
}

class SonClass extends SuperClass {
    static {
        System.out.println("子类初始化了！");
    }
}


