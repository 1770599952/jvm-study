package com.jvm.classloader;

public class ClassLoaderTest01 {

	public static void main(String[] args) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		System.out.println(classLoader);
		showParentClassLoader(classLoader);
	}

	private static void showParentClassLoader(ClassLoader classLoader) {
		if(null != classLoader) {
			System.out.println(classLoader.getParent());
			showParentClassLoader(classLoader.getParent());
		}
		return ;
	}

}
