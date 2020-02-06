package com.psl;

class MyThread extends Thread{
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
	}
	
}

class Mythread2 implements Runnable{

	@Override
	public void run() {
		
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+" i ="+i);
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
class SquareNumbers implements Runnable{
	@Override
	public void run() {
		
		for(int i=0;i<10;i++){
			System.out.println(Thread.currentThread().getName()+" i*i ="+(i*i));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}


public class ThreadDemo {
public static void main(String[] args) {
	MyThread thread1=new MyThread();
	thread1.setName("MyThread1");
	
	thread1.start();
	
	System.out.println(" this is some text ");
	
	Thread t1=new Thread(new Mythread2(),"Number thread");
	Thread t2=new Thread(new SquareNumbers(),"Square Thread");
	t1.start();
	t2.start();
	
}
}