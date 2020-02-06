
class Education implements Runnable{
	@Override
	public void run() {
		System.out.println("Education is started.......");
		System.out.println("Education is Going on.......");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Education is Completing.......");
		
	}
}
class Marriage implements Runnable{
	Thread t;
	public Marriage() {
		
	}
	public Marriage(Thread t) {
		this.t=t;
	}
	
	@Override
	public void run() {
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Marriage is started.......");
		System.out.println("Marriage is Completed.......");
		
	}
}
public class JoinDemo {

	
	public static void main(String[] args) {
		Education e=new Education();
		Thread t1=new Thread(e);
		Marriage m=new Marriage(t1);
		Thread t2=new Thread(m);
		t2.start();
		t1.start();
	}

}
