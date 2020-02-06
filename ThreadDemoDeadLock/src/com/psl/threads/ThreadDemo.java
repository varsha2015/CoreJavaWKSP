package com.psl.threads;

// Thread - java.lang  
// Runnable - interface
class Square implements Runnable
{

	@Override
	public void run() {
		for(int j=1;j<=5;j++){
			System.out.println( "j*j = "+(j*j));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}
class One implements Runnable{

	@Override
	public void run() {
		//System.out.println(Thread.currentThread().getName()+" Thread is running....");
		System.out.println(" thread is going to sleep ");
		try {
			for(int i=0;i<10;i++){
				System.out.println(" i= "+i);
				Thread.sleep(1000);
			}
		
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" thread running....");
	}
	
}

public class ThreadDemo {

	
	public static void main(String[] args) {
		
		One one=new One();
		Square sqr=new Square();
		Thread t1=new Thread(one);
		Thread t2=new Thread(sqr);
		t1.start();
		t2.start();
		/*try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		System.out.println("----- End of main------");
		
		
	}
	
	

}
