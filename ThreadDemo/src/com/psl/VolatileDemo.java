package com.psl;



class TestVolatile{
	private volatile int num=0;
	public int getInc()
	{
		return ++num;
	}
}

public class VolatileDemo implements Runnable {
	
	TestVolatile testVolatile=null;
	public VolatileDemo() {
		
	}
	
	
	public VolatileDemo(TestVolatile test) {
		this.testVolatile = test;
	}


	public static void main(String[] args) {
		TestVolatile v=new TestVolatile();
		VolatileDemo demo=new VolatileDemo(v);
		Thread t1=new Thread(demo);
		Thread t2=new Thread(demo);
		t1.start();
		t2.start();
	}
	void printNum()
	{
		System.out.println();
	}

	public void run() {
		for(int i=0;i<100;i++)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(testVolatile.getInc());
		}
	}
}
