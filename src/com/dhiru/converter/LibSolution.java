package com.dhiru.converter;

import java.util.Calendar;
import java.util.Date;

public class LibSolution {
	
	public static void main(String[] args) {
		int d1 = 9;
	    int y1 = 2015;
	    int m1 = 6;
	    int y2 = 2015;
	    int m2 = 6;
	    int d2 = 6;
	    
	    LibSolution ld = new LibSolution();
	    Date returnDate = ld.dataConversion(d1, m1, y1);
	    Date expectedDate = ld.dataConversion(d2, m2, y2);
	    
	    long diff =  ((returnDate.getTime() - expectedDate.getTime()) / (1000 * 60 * 60 * 24));
        System.out.println("the diffrence is: "+diff);
        long fineAmt = 0;
        
        if( diff > 0 && m2 == m1){
        	fineAmt = diff*15;
        	System.out.println("Book returned in the same month:" +fineAmt);
        	
        } else if ( diff > 0 && y2 == y1){
        	fineAmt = diff*500;
        	System.out.println("Book returned in the same year:" + fineAmt);
        } else {
        	fineAmt = 1000;
        	System.out.println("Book returned in a diff year: "+fineAmt);
        }        
        

	}
	
	public Date dataConversion(int day,int month, int year){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
}
