package com.psl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

class MyClass<T> implements TestInterface<T>{
	private T data;
	
	public MyClass() {
	}
	public MyClass(T data) {
		this.data=data;
	}
	/* (non-Javadoc)
	 * @see com.psl.TestInterface#show()
	 */
	public void show(){
		System.out.println(" Value of data :"+data);
	}
}


class Customer {
	private int id;
	private String name;
	private String city;	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(int id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
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
	
	
	/*public boolean equals(Object obj) {
		System.out.println("------------- equals is called-------");
		if( (obj instanceof Customer))			
		{
			Customer cust=(Customer) obj;
			if(cust.id==id && name.equals(cust.getName()) && city.equals(cust.getCity()))
			{
				return true;
			}
		}		
		
		return false;
	}
	@Override
	public int hashCode() {
		System.out.println(" ------- hash code is called-------");
		return id;
	}
	*/
	
	@Override
	public String toString() {
		return "[ id :"+id+" , "+" name :"+name+" , "+" City :"+city+ "]";
	}
	
	public int compareTo(Customer cust) {
		if(this.id==cust.id)
			return 0;
		if(this.id<cust.id)
			return -1;
		else
			return 1;	
	}
	
	
	
}



class GoldCustomer extends Customer{
public GoldCustomer() {
	// TODO Auto-generated constructor stub
}
	public GoldCustomer(int id, String name, String city) {
		super(id, name, city);
		// TODO Auto-generated constructor stub
	}
	
}
public class CollectionDemo {

	public static void main(String[] args) {
		CollectionDemo demo=new CollectionDemo();
		
		///demo.testList();
		//demo.testSet();
		
		// demo.testMap();
		
		TestInterface<String> obj1=new MyClass<String>("Hello");
		
		TestInterface<Integer> obj2=new MyClass<Integer>(2000);
		
		TestInterface<Customer> obj3=new MyClass<Customer>(new Customer(10,"aa","ss"));
		
		obj1.show();
		obj2.show();
		obj3.show();
		
		
		 Object o[] =new Customer[3];
		
		List<GoldCustomer> list=new ArrayList<GoldCustomer>();
		
		List<Object> list1=new ArrayList<Object>();
		
		demo.printCustomer(list1);
		
	}
	
	void printCustomer(List<? super Customer> list){
		list.add(new Customer(10,"aaa","pune"));
		list.add(new GoldCustomer(20,"bbbb","pune"));
		System.out.println(list);
	}

	public void testMap() {
		Map<Customer, Integer> map=new TreeMap<Customer, Integer>(new CompareByCity());
		Customer c1=new Customer(101,"Priya","Pune");	
		Customer c2=new Customer(102,"Anita","Mumbai");
		Customer c3=new Customer(103,"Teena","Pune");
		
		map.put(c1, 100);
		map.put(c2, 200);
		map.put(c3, 200);
	
		System.out.println(" Size of Map :"+map.size());
		System.out.println(map);
		
		
		/*Set<String> set=map.keySet();
		Iterator<String> it=set.iterator();
		
		while(it.hasNext()){
			String s=it.next();
			System.out.println(" Key :"+s+" Value :"+map.get(s));
		}*/
		
		
	}

	public void testSet() {
		Customer c1=new Customer(101,"Priya","Pune");	
		Customer c2=new Customer(102,"Anita","Mumbai");
		Customer c3=new Customer(103,"Teena","Pune");
		Customer c4=new Customer(100,"Teena","Pune");
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		String s=new String("ddd");
		
		Set<Customer> set=new TreeSet<Customer>(new CompareByCity());
		set.add(c1);
		set.add(c2);
		set.add(c3);
		set.add(c1);
		set.add(new Customer(101,"Priya","Pune"));
		set.add(c4);
		System.out.println(" size :"+set.size());
		System.out.println(set);		
		
		
		
	}

	public void testList(){
		int i=30;
	
		List<String> l=new ArrayList<String>();
		
		l.add("abc");l.add("abc");l.add("abc");
		
		l.add(new String("Hello"));
		
		l.add("sss");
		
		Iterator<String> it=l.iterator();
		
		while(it.hasNext()){
			String s=it.next();
			
			if(s.equals("abc"))
			{
				it.remove();
				//l.remove("abc");
				System.out.println(" element removed...");
			}}
			System.out.println(l);
			
			ListIterator<String> lit=l.listIterator();
			Collections.sort(l);
			System.out.println(l);
			Collections.shuffle(l);
			System.out.println(l);
			
		}
	
		
		
		
	}
