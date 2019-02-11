package com.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader{

	private String root;
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		
		byte[] classData = loadClassData(name);
		if(null == classData) {
			throw new ClassNotFoundException();
		}else {
			return defineClass(name, classData,0, classData.length);
		}
		
	}

	private byte[] loadClassData(String className) {
		
		String fileName = root + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
		
		try {
			InputStream ins = new FileInputStream(fileName);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			int bufferSize = 1024;
			byte[] buffer = new byte[bufferSize];
			int length = 0;
			while(-1 != (length = ins.read(buffer))) {
				byteArrayOutputStream.write(buffer, 0, length);
			}
			return byteArrayOutputStream.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}
	
	public static void main(String[] args) {
		
		MyClassLoader classLoader = new MyClassLoader();
		classLoader.setRoot("E:\\2017\\jvm-study");
		Class<?> testClass = null;
		
		try {
			testClass = classLoader.loadClass("com.oop.base.base.Test");
			Object object = testClass.newInstance();
			System.out.println(object.getClass().getClassLoader());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}
