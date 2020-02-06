package com.psl.threads;
class SquareCal implements Runnable
{
	private ThreadDemo demo=null;
	public SquareCal(ThreadDemo demo) {
		this.demo=demo;
	}

	@Override
	public void run() {
		for(int i=1;i<=15;i++)
		{
			System.out.printf("\nSquare of %d = %d",i,demo.calSquare(i));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
class CubeCal implements Runnable
{
	private ThreadDemo demo=null;
	Thread t=null;
	public CubeCal(ThreadDemo demo,Thread t) {
		this.demo=demo;
		this.t=t;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=5;i++)
		{
			System.out.printf("\nCube of %d = %d",i,demo.calCube(i));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			t.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" End...");
	}
}
public class ThreadDemo {

	
	public static void main(String[] args) {
		ThreadDemo demo=new ThreadDemo();
		SquareCal sq=new SquareCal(demo);
		Thread sqrThread=new Thread(sq," SquareCal ");
		Thread cubThread=new Thread(new CubeCal(demo,sqrThread)," CubeCal ");
		cubThread.start();
		sqrThread.start();
		
		
	}
	public int calSquare(int no)
	{
		return no*no;
	}
	public int calCube(int no)
	{
		return no*no*no;
	}
	
}
