package com.psl;

class Product {
	private double noofproduct = 0;

	public void produce(int amount) {
		noofproduct += amount;
	}

	public void consumed(int amount) {
		noofproduct -= amount;
	}

	public double getNoOfProducts() {
		return noofproduct;
	}
}

class Producer implements Runnable {
	Product pro = null;

	public Producer(Product noofproduct) {
		this.pro = noofproduct;
	}

	public  void produce() {

		System.out.println("No of products before producing is : "
				+ pro.getNoOfProducts());
		synchronized (pro) {
		while (pro.getNoOfProducts() >= 5) {
			System.out.println("Let the consumer consume it");
			try {
				pro.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		pro.produce(1);
		System.out.println("Now produced it : "	+ pro.getNoOfProducts());
		pro.notify();
				
		
				}
		
	}

	@Override
	public void run() {
        
		for(int i=0;i<50;i++)
			{
			produce();
			}
		

	}

}

class Consumer implements Runnable {
	Product pro = null;

	public Consumer(Product noofproduct) {
		this.pro = noofproduct;
	}

	public synchronized void consume (){
		synchronized (pro){
		while (pro.getNoOfProducts() <= 0) {
			System.out.println(" wait for producer to produce it.");
			try {
				pro.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(" Now consuming :"+pro.getNoOfProducts());
		pro.consumed(1);
		
		
		pro.notifyAll();
		}
		
	}
	@Override
	public void run() {
	
		for(int i=0;i<50;i++)
		{
			consume();
		}

	}

}

public class ProducerConsumerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Product pro = new Product();
		Producer producer = new Producer(pro);
		Consumer consumer = new Consumer(pro);
		Thread T1 = new Thread(producer, "A");
		Thread T2 = new Thread(consumer, "b");
		T1.start();
		T2.start();*/

		int answer = +1;     
		  answer++;
		  --answer;
		  System.out.println(+answer++);
		  System.out.println(answer);
	}

}
