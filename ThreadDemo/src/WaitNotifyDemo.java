
class JointAccount
{
	public int balance=0;
	public void deposit(int amt)
	{
		balance=balance+amt;
	}
	public void withdraw(int amt)
	{
		balance=balance-amt;
	}
}
class Dipositer implements Runnable
{
 private JointAccount acct;

	public Dipositer(JointAccount acct) {
	
		this.acct = acct;
	}

	@Override
	public void run() {
		
		synchronized (acct) {
			
		
		acct.deposit(100);
		if(acct.balance<0)
		{
			System.out.println("BIG Problem..........");
		}
		acct.notifyAll();
		}
		
	}
 
}
class Withdraw implements Runnable
{
 private JointAccount acct;

	public Withdraw(JointAccount acct) {
	
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
		acct.withdraw(100);
		
		if(acct.balance<0)
		{
			System.out.println("BIG Problem..........");
		}
		}
	}
 
}
public class WaitNotifyDemo {

	
	public static void main(String[] args) {
		JointAccount acct=new JointAccount();
		Dipositer depositer=new Dipositer(acct);
		Withdraw withdrawer=new Withdraw(acct);
		Thread t1=new Thread(depositer);
		Thread t2=new Thread(withdrawer);
		t2.start();
		t1.start();
	
	}

}
