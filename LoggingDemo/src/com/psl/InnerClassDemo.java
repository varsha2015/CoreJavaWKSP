package com.psl;

import java.util.*;

class Employee{
	
}
public class InnerClassDemo {
	private int i;
	  private class Test{
		
	}

	  static class TestStatic{
		  
	  }
	  
	  public void sortByName(){
	  class MyComparator implements Comparator<Employee>{

			@Override
			public int compare(Employee arg0, Employee arg1) {
				return 0;
			}
			  
		  }
		  List<Employee> list=null;
		  
		  Collections.sort(list,new MyComparator());
	  }
	  public void sortByCity(){
		  
List<Employee> list=null;
		  
		  Collections.sort(list,new Comparator<Employee>(){

			@Override
			public int compare(Employee arg0, Employee arg1) {
				// TODO Auto-generated method stub
				return 0;
			}
			  
		  }
				  
		  );
		  
	  }
	  
	public static void main(String[] args) {
		InnerClassDemo demo=new InnerClassDemo();
		InnerClassDemo.Test t1=new InnerClassDemo().new Test();
		InnerClassDemo.Test t2=demo.new Test();
		
		InnerClassDemo.TestStatic ts1=new InnerClassDemo.TestStatic();
		
		
		
	}

}
