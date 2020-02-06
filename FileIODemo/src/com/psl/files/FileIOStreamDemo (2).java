package com.psl.files;

import java.io.*;
public class FileIOStreamDemo {

	public static void main(String[] args) {
		String sourceFile="C:\\Users\\Public\\Videos\\Sample Videos\\Wildlife.wmv";
		String destFile="mydata\\resources\\video";
		File file=new File(destFile);
		if(!file.exists()){
			file.mkdirs();
		}
		
		/*FileInputStream in=null;
		FileOutputStream out=null;
		*/
		BufferedInputStream bin=null;
		BufferedOutputStream bout=null;
		
		try {
			
			bin=new BufferedInputStream(new FileInputStream(sourceFile));
			bout=new BufferedOutputStream(new FileOutputStream(destFile+File.separator+"copy.wmv"));
			
			byte [] data=new byte[100];
			long start=System.currentTimeMillis();
			System.out.println(" copy started @ "+start+" ms");
			
			while( bin.read(data)!=-1  ){
				bout.write(data);
			}
			long end=System.currentTimeMillis();
			System.out.println(" copy ended @ "+end+" ms");
			System.out.println(" Total Time taken  "+(end-start)+" ms");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally{
		
				try {
					if(bin!=null)
					bin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
		}
		
		
		
		
		

	}

}
