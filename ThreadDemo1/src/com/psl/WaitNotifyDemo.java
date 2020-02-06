package com.psl;

class JointAccount
{
	boolean flag=false;
	double balance=0;
	public void deposit(int amt)
	{
		balance=balance+amt;
	}
	public void withdraw(int amt)
	{
		balance=balance-amt;
	}
}

class Depositor implements Runnable 
{
	JointAccount acc=null;
	
	public Depositor(JointAccount acc) {
		super();
		this.acc = acc;
	}

	public void run() {
	
		
		synchronized (acc) {
			while(acc.flag)
			{
				try {
					acc.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			acc.deposit(100);
			acc.flag=true;
			if(acc.balance<0)
			{
				System.out.println(" Big Problem......"+acc.balance);
			}
			acc.notify();
			System.out.println("in run.."+Thread.currentThread().getName()+" "+acc.balance);
			
		}
	
	}
	
}
class Withdrawer implements Runnable 
{
	JointAccount acc=null;

	public Withdrawer(JointAccount acc) {
		super();
		this.acc = acc;
	}

	public void run() {
		int j=0;
	
	
			
		synchronized (acc) {
			while(!acc.flag)
			{			
			
			try {
				acc.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			}
			acc.withdraw(100);
			acc.flag=false;
			acc.notify();
			System.out.println("in run.."+Thread.currentThread().getName()+" "+acc.balance);
		}
		
		}
		
		
	}
	


public class WaitNotifyDemo {

	
	public static void main(String[] args) {
		JointAccount ac=new JointAccount();
		Depositor d=new Depositor(ac);
		Thread t1=new Thread(d);
		t1.setName("Depositor");
		Withdrawer w=new Withdrawer(ac);
		Thread t2=new Thread(w);
		t2.setName("Withdrawer");
		t2.start();
		t1.start();
	}

}
