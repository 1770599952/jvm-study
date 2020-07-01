package com.jvm.classloader;

/**
 * 基础类型数组类由引导类加载器来加载。
 *
 */
public class ClassLoaderTest10 {
    public static void main(String[] args) {
        int[] testArr = new int[10];
        System.out.println(int[].class);
        System.out.println(int[].class.getClassLoader());
    }
}
