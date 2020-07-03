package com.jvm.classloader;

import java.beans.Beans;

public class ClassLoaderTest06 extends Beans{

	//全盘负责--当一个ClassLoader装载一个类时，除非显示地使用另一个ClassLoader，该类所依赖及引用的类也由这个ClassLoader装入。
	public static void main(String[] args) {

	}
}
