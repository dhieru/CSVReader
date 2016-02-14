package com.dhiru.converter;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class LibraryDues {
	
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();
        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();
        
        // Assuming the book is issued for 30 days or 1 month

		/*int d1 = 10;
	    int y1 = 2016;
	    int m1 = 0;
	    int y2 = 2016;
	    int m2 = 1;
	    int d2 = 14;*/
        
        LibraryDues ld = new LibraryDues();
        Date loanDate = ld.dataConversion(d1,m1,y1);
        Date dueDate = ld.dataConversion(d2, m2, y2);
        
        Calendar c = Calendar.getInstance();
        c.setTime(loanDate);
        c.add(Calendar.DATE, 30);
        Date eDate = c.getTime();
     //   long expectedDate = loanDate.getTime()+(30*1000*60*60*24);
        System.out.println("The book is loaned on: "+loanDate);
        System.out.println("The return date is: "+dueDate);
        System.out.println("The expected date to return the book "+eDate);
       // Calendar cal = Calendar.getInstance();
       // cal.setTime(eDate);
        int expectedDateMonth = c.get(Calendar.MONTH);
       
        int expectedYear = c.get(Calendar.YEAR);
        
        
        long diff =  ((dueDate.getTime() - eDate.getTime()) / (1000 * 60 * 60 * 24));
        System.out.println("the diffrence is :"+diff);
        long fineAmt = 0;
        
        if( diff > 0 && m2 == expectedDateMonth){
        	fineAmt = diff*15;
        	System.out.println("Book returned in the same month:" +fineAmt);
        	
        } else if ( diff > 0 && y2 == expectedYear){
        	fineAmt = diff*500;
        	System.out.println("Book returned in the same year:" + fineAmt);
        } else {
        	fineAmt = 1000;
        	System.out.println("Book returned in a diff year: "+fineAmt);
        }        
        
    }
	
	 /*public int daysBetween(Date d1, Date d2){
         return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
 }*/

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
