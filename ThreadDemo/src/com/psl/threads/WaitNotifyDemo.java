package com.psl.threads;

class JointAccount
{
private	double balance=0;
	public void deposit(int amt)
	{
		balance+=amt;
	}
	public void withdraw(int amt)
	{
		balance-=amt;
	}
	public double getBalance() {
		return balance;
	}
	
}
class Depositor implements Runnable
{
	JointAccount acct=null;
	public Depositor(JointAccount acct) {
		this.acct=acct;
	}

	@Override
	public void run() {
		synchronized (acct) {
			acct.deposit(1000);
			if(acct.getBalance()<0)
			{
				System.out.println(" Big Problem...  Can't Withdraw");
			}
			System.out.println(" Amount Deposited ... Balance : "+acct.getBalance() );
			acct.notifyAll();
		}
	}
	
}
class Withdraw implements Runnable
{
	JointAccount acct=null;
	public Withdraw(JointAccount acct) {
		this.acct=acct;
	}

	@Override
	public void run() {
		synchronized (acct) {
			try {
				acct.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			acct.withdraw(1000);
			if(acct.getBalance()<0)
			{
				System.out.println(" Big Problem...  ");
			}
			System.out.println(" Amount Withdrawn ... Balance : "+acct.getBalance() );
		}
	}
	
}
public class WaitNotifyDemo {

	
	public static void main(String[] args) {
		
		JointAccount ac=new JointAccount();
		Depositor depositor=new Depositor(ac);
		Withdraw withdraw=new Withdraw(ac);
		Thread t1=new Thread (depositor,"Ram");
		Thread t2=new Thread (withdraw,"Shyam");
		t2.start();
		t1.start();
		
	}

}
