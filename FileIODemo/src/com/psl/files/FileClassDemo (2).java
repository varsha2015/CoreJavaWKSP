package com.psl.files;

import java.io.*;

public class FileClassDemo {

	public static void main(String[] args) {
		File file=new File("d:\\javapro\\Myfile.txt");
		System.out.println(" file exists ? :"+file.exists());
		if(!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else
		{
			System.out.println(" path :"+file.getAbsolutePath());
			System.out.println(" Size :"+file.length() +" bytes");
		}
		
		File dir=new File("Mydata");
		if(! dir.exists()){
			dir.mkdir();
			System.out.println(dir.getName()+" is created at "+dir.getAbsolutePath());
		}
		File dirs=new File("Mydata\\resources\\files");
		if(! dirs.exists()){
			dirs.mkdirs();
			System.out.println(dirs.getName()+" is created at "+dirs.getAbsolutePath());
		}
		
		File fileList[]= dirs.listFiles();
		System.out.println(" List of file :"+dirs.getAbsolutePath());
		for(File f:fileList){
			if(f.isFile()){
				System.out.println(f.getName() +" file "+ f.length()+" bytes");
			}
			else{
				System.out.println(f.getName() +" dir ");
			}
		
		}
		
	}

}
