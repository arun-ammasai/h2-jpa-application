package com.bytecodevelocity.reflection;

import java.lang.reflect.Method;

public class DynamicMethodCall {
	public static void main(String[] args) throws Exception {
		// Class , Method , Obj , Invoke
		Class<?> mClass = Class.forName("com.bytecodevelocity.reflection.CallMe");
		Method method = mClass.getMethod("welcome", String.class);
		Object obj = mClass.newInstance();
		String output = (String)method.invoke(obj, "Arun");
		System.out.println("Output :"+output);
	}
}
