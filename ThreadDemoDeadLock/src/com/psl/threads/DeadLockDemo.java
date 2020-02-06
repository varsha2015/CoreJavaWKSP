package com.psl.threads;
class Resource1 implements Runnable {
	   public void run() {
	       synchronized(Resource1.class){
	    	   System.out.println("Executing Resource 1......");
	          synchronized(Resource2.class){
	        	  
	               System.out.println(" Using Resource 2..... ");
	               
	           }
	          try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	          System.out.println(" Released Resource 2......");
	       }
	   }
	}
	class Resource2 implements Runnable {
	   public void run() {
	        synchronized(Resource2.class){
	        	 System.out.println("Executing Resource 2......");
	           synchronized(Resource1.class){
	                  System.out.println("  Using Resource 1.....");
	            }
	           System.out.println(" Released Resource 1......");
	        } 
	   }
	}
	
public class DeadLockDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Thread(new Resource1()).start();
	     new Thread(new Resource2()).start();
	}

}
