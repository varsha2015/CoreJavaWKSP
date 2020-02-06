package com.psl;



class Number{
	int count;
	
	  public int increment(){
		  synchronized(this){
			  count++;
		  
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return count;
		}		
	}
}

class Thread1 implements Runnable {
	Number num;
	public Thread1(Number num) {
		this.num=num;
	}
	@Override
	public void run() {
		//System.out.println(Thread.currentThread().getName()+" is running ");
		for(int i=0;i<20;i++){
			System.out.println(" Number : "+num.increment());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
	}	
}

class Thread2 implements Runnable {
	Number num;
	public Thread2(Number num) {
		this.num=num;
	}
	@Override
	public void run() {
		//System.out.println(Thread.currentThread().getName()+" is running ");
		for(int i=0;i<20;i++){			
				System.out.println(" Number : "+num.increment());		
			
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}	
}



public class ThreadDemo2 {
	public static void main(String[] args) {
		
		Number num=new Number();		
		Thread t1=new Thread(new Thread1(num));
		Thread t2=new Thread(new Thread2(num));
		t1.start();
		t2.start();
		try {
			t1.join(); // main thread will wait t1 to finish
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("------------ This is End of Main -----");
		
	}

}
