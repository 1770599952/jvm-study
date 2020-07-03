package com.jvm.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * 类加载器与instanceof关键字
 *
 * 类加载器与类全限定名唯一确定类
 */
public class ClassLoaderTest14 {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException();
                }
            }
        };

        Object obj = classLoader.loadClass("com.jvm.classloader.ClassLoaderTest14").newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof com.jvm.classloader.ClassLoaderTest14);
    }

}
