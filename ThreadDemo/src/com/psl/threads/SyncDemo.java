package com.psl.threads;

class Account
{
	private double bal=5000;
	public void withdraw(double amt)
	{
		if(amt<bal)
		{
			bal=bal-amt;
		}
		else
		{
			System.out.println(" Not Enough money  Problem.....");
		}
		
	}
	public double getBal()
	{
		return bal;
	}
}


public class SyncDemo implements Runnable {
Account acct=null;
	
public SyncDemo(Account acct) {
	this.acct=acct;
}
	public static void main(String[] args) {
		Account ac=new Account();
		SyncDemo demo=new SyncDemo(ac);
		Thread t1=new Thread(demo," Person 1 :");
		Thread t2=new Thread(demo," Person 2 :");
		t2.start();
		t1.start();
	}

	public void makeWithdraw(double amt)
	{
		acct.withdraw(amt);
	}
	@Override
	public void run() {
		System.out.println( Thread.currentThread().getName() +" is checking bal ");
		
		synchronized (acct) {
			
			double bal=acct.getBal();
			System.out.println(" bal : "+bal);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		double amt=4000;
		if(amt<bal)
		{
			acct.withdraw(amt);
			System.out.println(Thread.currentThread().getName() +" has  Withdrawn .......");
		}
		
		System.out.println(" current bal : "+acct.getBal());
		}
	}
	

}
