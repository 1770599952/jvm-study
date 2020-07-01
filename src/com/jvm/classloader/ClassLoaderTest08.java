package com.jvm.classloader;

/**
 * 被动引用
 *
 * 通过数组定义来引用类，不会触发类的初始化
 *
 * 它是一个由虚拟机自动生成的、直接继承于java.lang.Object的子类，创建动作由 字节码指令newarray触发。
 */
public class ClassLoaderTest08 {
    public static void main(String[] args) {
        ArrayClass[] arrayClasses = new ArrayClass[10];
        System.out.println(ArrayClass[].class);
        System.out.println(ArrayClass[].class.getClassLoader());
    }
}
class ArrayClass{
    static {
        System.out.println("引用类型");
    }
}
