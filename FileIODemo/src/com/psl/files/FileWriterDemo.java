package com.psl.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {

	public static void main(String[] args) {
		
		FileWriter fw=null;
		
		try {
			fw=new FileWriter(new File("mydata\\resources\\files\\one.txt"));
			fw.write("This is sample text");
			System.out.println(" File updated....");
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
			if(fw!=null){
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		FileReader fr=null;
		try {
			fr=new FileReader(new File("mydata\\resources\\files\\one.txt"));
			
			int i;
			while( (i=fr.read())!=-1)
			{
				System.out.print((char)i);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(fr!=null){
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		
		
	}

}
