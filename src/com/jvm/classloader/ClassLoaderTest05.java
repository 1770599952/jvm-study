package com.jvm.classloader;

import java.beans.Beans;
import java.util.ArrayList;
import java.lang.String;

public class ClassLoaderTest05 extends Beans{

	//全盘负责--当一个ClassLoader装载一个类时，除非显示地使用另一个ClassLoader，该类所依赖及引用的类也由这个ClassLoader装入。
	private static ArrayList<String> list = new ArrayList<>();
	
	public static void main(String[] args) {
		
		ClassLoader classLoader = ClassLoaderTest05.class.getClassLoader();
		System.out.println(classLoader);
		System.out.println(list.getClass().getClassLoader());
	
	}
}
