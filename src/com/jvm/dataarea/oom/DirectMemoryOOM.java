package com.jvm.dataarea.oom;

import sun.misc.Unsafe;
import java.lang.reflect.Field;

/**
 * 直接内存溢出: -Xmx20m -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {

    private static final int _1mb = 1024 * 2014;

    public static void main(String[] args) throws Exception{
        /**
         *  DirectMemory容量可通过-XX：MaxDirectMemorySize指定，如果不指定，则默认与Java
         * 堆最大值（-Xmx指定）一样，代码清单2-9越过了DirectByteBuffer类，直接通过反射获取
         * Unsafe实例进行内存分配（Unsafe类的getUnsafe（）方法限制了只有引导类加载器才会返回
         * 实例，也就是设计者希望只有rt.jar中的类才能使用Unsafe的功能）。因为，虽然使用
         * DirectByteBuffer分配内存也会抛出内存溢出异常，但它抛出异常时并没有真正向操作系统申
         * 请分配内存，而是通过计算得知内存无法分配，于是手动抛出异常，真正申请分配内存的方
         * 法是unsafe.allocateMemory（）。
         */
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while(true){
            unsafe.allocateMemory(_1mb);
        }
    }
}
