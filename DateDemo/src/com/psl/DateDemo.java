package com.psl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
	public static void main(String[] args) {
		Date date=new Date();
		System.out.println("Today : "+date);
		Date pastDate=new Date(0);
		System.out.println("Past Date : "+pastDate);
		
		Calendar cal=Calendar.getInstance();
		
		if(date.before(pastDate)){
			
		}
		
		System.out.println(" Today : "+cal.getTime());
		
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy");
		
		System.out.println(" Today : "+df.format(date));
		
		String shipDate="13-2-2014";
		
		try {
			df.setLenient(false);
			Date d=df.parse(shipDate);
			
			System.out.println("Ship date :"+d);			
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(" current Cal date :" +cal.getTime());
		
		cal.add(Calendar.MONTH, 4);
		
		
		System.out.println(" after 4 months Cal date :" +cal.getTime());
		System.out.println();
		
		
		
	}

}
