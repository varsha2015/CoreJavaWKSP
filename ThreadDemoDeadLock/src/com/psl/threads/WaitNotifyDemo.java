package com.psl.threads;

class JointAccount{
	private double balance=0;
	
	public void deposit(int amt){
		balance+=amt;
	}
	
	public void withdraw(int amt){
		balance-=amt;
	}
	public double getBalance() {
		return balance;
	}
}

class Depositor implements  Runnable{
	JointAccount acct;
	
	public Depositor(JointAccount acct) {
		this.acct=acct;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+ " is depositing amt... ");
		synchronized (acct) {
			acct.deposit(2000);
			acct.notifyAll();
		}
			
	}
	
}

class Withdrawer implements Runnable{
	JointAccount acct;
	public Withdrawer(JointAccount acct) {
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
			System.out.println(Thread.currentThread().getName()+" is Withdrawing ....");
			acct.withdraw(3000);
		}
		
	}
}

public class WaitNotifyDemo {
	public static void main(String[] args) {
		JointAccount acct=new JointAccount();
		Depositor dep=new Depositor(acct);
		Withdrawer wid=new Withdrawer(acct);
		Thread t1=new Thread(dep);
		Thread t2=new Thread(wid);
		t2.start();
		t1.start();
	}
	
	
	
	
	
	
	
}
