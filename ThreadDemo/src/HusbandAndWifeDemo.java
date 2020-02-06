
class BankAccount{
	double balace=5000;
	public void withdraw(int amt)
	{
		balace=balace-amt;
	}
}


public class HusbandAndWifeDemo implements Runnable {

	BankAccount acct=null;
	public HusbandAndWifeDemo(BankAccount acct) {
		this.acct=acct;
	}
	public static void main(String[] args) {
		BankAccount acct=new BankAccount();
		HusbandAndWifeDemo hw=new HusbandAndWifeDemo(acct);
		Thread t1=new Thread(hw);
		t1.setName("Husband :");
		Thread t2=new Thread(hw);
		t2.setName("Wife    :");
		t2.start();
		t1.start();

	}

	@Override
	public void run() {
		makeWithdrawl(4000);
		if(acct.balace<0)
		{
			System.out.println(" IT IS BIG PROBLEM");
		}
	}

	public  void makeWithdrawl(int amt)
	{
		System.out.println(Thread.currentThread().getName()+" Has entered inside Makewithdrawl");
		System.out.println(Thread.currentThread().getName()+" is goining to check balance");
		
			if(amt<acct.balace)
			{
				System.out.println(Thread.currentThread().getName()+" has checked balance ");
				System.out.println(Thread.currentThread().getName()+" is going to withdraw ");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				acct.withdraw(amt);
				System.out.println(Thread.currentThread().getName()+" has Withdrawn "+amt);
			}
			else
			{
				System.out.println("Not Enough Money" );
			}
			
		
		
	}
}
