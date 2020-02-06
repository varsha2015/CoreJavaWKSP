package com.psl.files;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIODemo {

	public static void main(String[] args) {
		ObjectIODemo demo=new ObjectIODemo();
		demo.storeObject();
		System.out.println("Reading Objects from file");
		demo.readObject();	
	}
	
	void storeObject(){
		Customer c1=new Customer(100,"Deepa","Pune");
		c1.setTitle("Miss");
		c1.setAddress(new Address(41100,"Pune"));
		Customer c2=new Customer(101,"Neha","Pune");
		c2.setTitle("Mrs");
		c2.setAddress(new Address(4340,"Mumbai"));
		Customer c3=new Customer(102,"Teena","Pune");
		c3.setTitle("Miss");
		c3.setAddress(new Address(4343,"Pune"));
		ObjectOutputStream out=null;
		try {
			out = new ObjectOutputStream(new FileOutputStream("cust.dat"));
			out.writeObject(c1);
			out.writeObject(c2);
			out.writeObject(c3);
			System.out.println(" Data stored in file....");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(out!=null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}	
			}
			
		}
		
	}
	void readObject(){
		ObjectInputStream in;
		try {
			in = new ObjectInputStream(new FileInputStream("Cust.dat"));
			Customer c;
			while((c=(Customer)in.readObject())!=null){
				System.out.println(c);
			}			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		
	}
}
