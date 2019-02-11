package com.jvm.classloader;

public class ClassLoaderTest02 {

	public static void main(String[] args) {
		ClassLoader classLoader = ClassLoaderTest02.class.getClassLoader();
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
