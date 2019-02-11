package com.jvm.classloader;

import java.beans.Beans;

public class ClassLoaderTest04 extends Beans{

	public static void main(String[] args) {
		
		ClassLoader classLoader = ClassLoaderTest04.class.getClassLoader();
		System.out.println(classLoader);
		
		System.out.println("父类:");
		ClassLoader superClassLoader = ClassLoaderTest04.class.getSuperclass().getClassLoader();
		System.out.println(superClassLoader);
		showParentClassLoader(superClassLoader);
	}

	private static void showParentClassLoader(ClassLoader classLoader) {
		if(null != classLoader) {
			System.out.println(classLoader.getParent());
			showParentClassLoader(classLoader.getParent());
		}
		return ;
	}

}
