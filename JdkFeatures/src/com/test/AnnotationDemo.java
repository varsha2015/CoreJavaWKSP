package com.test;

import java.util.concurrent.Future;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test{
	String author();
}


class TestSingleton{
	TestSingleton t=null;
	private TestSingleton() {
		
	}
	TestSingleton getInSingletonInstance(){
		if(t==null){
			t=new TestSingleton();
		}
		return t;
	}
}

class A{
	@Test(author="sss")
	static public void show(){
		System.out.println(" in show ");
	}
}

public class AnnotationDemo extends A implements Runnable{

	public static void main(String[] args) {
		
		Method[] m=A.class.getDeclaredMethods();
		for(Method met:m){
			try {	
				/*Annotation[] annot=met.getAnnotations();	
				if(annot.equals(Test.class)){
					System.out.println("test annotation present");
				}*/
				Test t=met.getAnnotation(Test.class);
				if(t.author().equals("sss"))
					System.out.println("author is sss hence processing");
				
			} catch (Exception e) {
				
			}
		}
		
		
	}


	

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		Date d=new Date();
		d.getDate();
	}

}
