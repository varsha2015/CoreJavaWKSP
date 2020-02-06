package com.psl;

class JointAccount {

	private double balance = 0;

	public void deposit(int amt) {
		balance += amt;
	}

	public void withdraw(int amt) {
		balance -= amt;
	}

	public double getBalance() {
		return balance;
	}

}

class Depositor implements Runnable {
	JointAccount acct = null;

	public Depositor(JointAccount acct) {
		this.acct = acct;
	}

	@Override
	public void run() {
		synchronized (acct) {
			
			System.out.println(" before deposit bal is "+acct.getBalance());
			acct.deposit(10000);
			System.out.println(" before deposit bal is "+acct.getBalance());
			acct.notifyAll();
		}
	}
}

class Withdrawer implements Runnable {
	JointAccount acct = null;

	public Withdrawer(JointAccount acct) {
		this.acct = acct;
	}

	@Override
	public void run() {
		synchronized (acct) {
			try {
				acct.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			System.out.println(" withdrawing amount.....");
			System.out.println(" before withdraw Balance is ... "+acct.getBalance());
			acct.withdraw(2000);
			System.out.println(" after withdraw Balance is ... "+acct.getBalance());
		}
	}
}

public class WaitNotifyDemo {

	public static void main(String[] args) {
		JointAccount acct=new JointAccount();
		Withdrawer  withdraw=new Withdrawer(acct);
		Depositor depositor=new Depositor(acct);
		Thread withd=new Thread(withdraw,"A");
		Thread depo=new Thread(depositor,"B");
		
		withd.start();
		depo.start();
		
		
	}

}
