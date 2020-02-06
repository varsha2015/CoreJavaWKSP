package com.psl;
class TestV
{
	private volatile int i=0;
	public int getIncr()
	{
		i++;
		return i;
	}
}


class TestThread implements Runnable
{
	TestV obj=null;
	public TestThread(TestV obj) {
		this.obj=obj;
		
	}
	
	
	public void run() {
		
		for(int i=0;i<100;i++)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
				System.out.println(obj.getIncr());
			
			
		}
	}
}
public class ThreadDemo {

	
	public static void main(String[] args) {
		TestV vol=new TestV();
		Thread t1=new Thread(new TestThread(vol));
		Thread t2=new Thread(new TestThread(vol));
			
		t1.start();
		t2.start();
		
	}

}
