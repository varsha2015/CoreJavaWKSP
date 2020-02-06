package com.psl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerDemo {
	
	public static void main(String[] args) {
		//Scanner scr=new Scanner(System.in); //input from keyboard
		try {
			Scanner scr=new Scanner(new File("abc.txt")); //input from file
			scr.useDelimiter(":");
			while(scr.hasNext()){
				String s=scr.next();
				System.out.println(s);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		
		String str="sun,mon,tue,wed,thu,fri";
		
		str.split(",");
		
		
		Scanner sc=new Scanner(str);
		sc.useDelimiter(",");
		while(sc.hasNext()){
			String s=sc.next();
			System.out.println(s);
		}
		
		
		
	}

}
