package com.psl.files;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Person {
	private String title;

	public Person() {
		System.out.println("---- default constructor called for Person-----");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return title;
	}
}

public class Customer extends Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3579876703575210974L;
	private int id;
	private String name;
	private transient String city;
	private transient Address address=new Address();

	public Customer() {
		System.out.println("---- default constructor called-----");
	}

	public Customer(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		System.out.println("---- parameter constructor called-----");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "[" + getTitle() +"\t"+ id + "\t" + name + "\t" + city +"\t"+address+ "]";
	}
	
	private void writeObject(ObjectOutputStream os){
		try {
			os.defaultWriteObject();
			
			os.writeInt(address.getStreetCode());
			os.writeObject(address.getCityName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	private void readObject(ObjectInputStream in){
		try {
			in.defaultReadObject();
			Address address=new Address();
			address.setStreetCode(in.readInt());
			address.setCityName((String)in.readObject());
			this.address=address;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
