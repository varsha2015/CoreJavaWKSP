package com.psl.threads;

class Number {
	private int num;
	   int getIncrNum(){
		   
		   //add some delay for simulation
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//observe the o/p without sync
		return num++;
		
		
		
	    //observe the o/p with sync block / method and see the difference
		/*synchronized (this) {
			return num++;
		}*/
		 
		
		
	}
	
}

class One1 implements Runnable{
	Number num;
	public One1(Number num) {
		this.num=num;
	}
	
	@Override
	public void run() {
		for(int i=0;i<30;i++){	
			
			System.out.println(num.getIncrNum());
		}
		
	}	
}

class Two implements Runnable{
	Number num;
	public Two(Number num) {
		this.num=num;
	}
	
	@Override
	public void run() {
		for(int i=0;i<30;i++){
			
			
			System.out.println(num.getIncrNum());
		}
	}
}

public class SyncDemo {
	public static void main(String[] args) {
		Number number =new Number();
		One1 one=new One1(number);
		Two two=new Two(number);
		Thread t1=new Thread(one);
		Thread t2=new Thread(two);
		
		t1.start();
		t2.start();
		
	}
	
	
	
	
	
}
