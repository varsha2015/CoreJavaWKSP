package com.test;
import static java.lang.Math.*;
/*Tiger
 * 
 * Autoboxing /Unboxing
 * Enhanced for loop
 * Static import
 * Generics
 * Annotation
 * Enum
 * varargs
 * 
 */

enum Days{
	Mon(10),Tue(20),Wed(30),Ths(40),Fri(50),Sat(60)
	{public String getMessage(){
		return " Week End";
	}},
	Sun(70)
	{public String getMessage(){
		return " Week End";
	}};
	int value;
	private Days(int value) {
		this.value=value;
	}
	public int getValue() {	
		return value;
	}
	public String getMessage(){
		return " Week day";
	}
}


public class Java5FeaturesDemo {

	
	public static void main(String... args) {
		
		/*for(Days d:Days.values()){
			System.out.println(" day :"+d +" ordinal :"+d.ordinal()+" value :"+d.getValue()+" message :"+d.getMessage());
		}
	
		Days day=Days.valueOf("Tue");
		Days dd=Days.valueOf("Sat");
		
		if(day.equals(dd)){
			System.out.println(" equals ");
		}		*/
		
        int i = 1234567890;
        float j = i;
        System.out.println(j);

		
	}
	/*public static void test(byte j){
		System.out.println("byte :"+j);
	}*/
	/*public static void test(Byte j){
		System.out.println("Byte parameter :"+j);
	}*/
	/*public static void test(long j){
		System.out.println("long parameter :"+j);
	}*/
	
	public static void test(int...x){
		for(int no:x){
			System.out.println(no);
		}
	}
}
