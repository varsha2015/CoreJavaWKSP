package com.psl;

import java.io.IOException;
import java.util.logging.*;


public class TestLogger {
	static Logger logger=Logger.getLogger(TestLogger.class.getName());
	
	static{
		try {
			logger.addHandler(new FileHandler("logs.xml"));
			logger.setLevel(Level.FINE);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		int i=10,j=0;
		
		try{
			int c=i/j;
		}catch(Exception e){
			logger.info(" Exception occured "+e.getMessage());
			logger.fine("This can be ignored");
		}
		
	}

}
