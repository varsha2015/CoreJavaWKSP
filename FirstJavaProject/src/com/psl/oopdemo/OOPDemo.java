package com.psl.oopdemo;

abstract class Animal{
	public abstract void eat();
}

interface MyInterface{
	 int i=30;// default static final
	 void display();//default public abstract
	
}

class Dog extends Animal{
	public  void eat(){
		System.out.println(" dog eat..");
	}
	public void bark(){
		
	}
}

class Cat extends Animal{
public  void eat(){
	System.out.println(" cat eat..");
	}
}

interface A{
	void showA();
}
interface B{
	void showB();
}
interface C{
	void showC();
}
interface D{
	void showD();
}
interface E{
	void showE();
}
interface F{
	void showF();
}
interface G{
	void showG();
}

 

public class OOPDemo  implements MyInterface,A,B,C,D,F,G{
	public static void main(String[] args) {
		OOPDemo demo=new OOPDemo();
		
		demo.show(new Dog());
		demo.show(new Cat());
		
	}
	
	public void show(Animal a){
		a.eat();
		if(a instanceof Dog){
			((Dog)a).bark();
		}
	}

	public void display() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showA() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showB() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showC() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showD() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showF() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showG() {
		// TODO Auto-generated method stub
		
	}
	
	
}
