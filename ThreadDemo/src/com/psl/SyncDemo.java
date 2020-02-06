package com.psl;

class BankAccount
{
	private double balance=5000;
	public  void withdraw(int amt)
	{
		this.balance=balance-amt;
	}
	public double getBal()
	{
		return this.balance;
	}
}


public class SyncDemo implements Runnable{
	BankAccount acc;
	public SyncDemo(BankAccount ac) {
		acc=ac;
	}
	public static void main(String[] args) {
		BankAccount ac=new BankAccount();
		SyncDemo demo=new SyncDemo(ac);
		Thread t1=new Thread(demo);
		Thread t2=new Thread(demo);
		t1.setName("Raj");
		t2.setName("Neha");
		t1.start();
		t2.start();
	}

	public void run() {
		makeWithdraw(4000);
		if(acc.getBal()<0)
		{
			System.out.println(" Big Problem..........");
		}
		System.out.println( " current Bal "+acc.getBal());
	}
	public void makeWithdraw(int amt)
	{
		System.out.println(Thread.currentThread().getName()+"  has entered into ATM .....");
		System.out.println(Thread.currentThread().getName()+"  is checking balance .....");
		System.out.println(" curent bal: "+acc.getBal());
		synchronized (acc) {
			if(amt < acc.getBal())
			{
				System.out.println(Thread.currentThread().getName()+" has found  bal is ok ..");
				System.out.println(Thread.currentThread().getName()+" Now start withdrawing  ..");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				acc.withdraw(amt);
				System.out.println(" Transaction successful....");
			}else
			{
				System.out.println(" Not enough balance......");
			}
		}
		
	}
	
}
