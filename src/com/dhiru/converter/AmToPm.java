package com.dhiru.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AmToPm {

	public static void main(String[] args) throws ParseException {
        System.out.println("This is start of the");
		Scanner in = new Scanner(System.in);
        String time = in.next();
        DateFormat df = new SimpleDateFormat("hh:mm:ssaa");
        DateFormat df2 = new SimpleDateFormat("HH:mm:ss");
        Date date = df.parse(time);
        String str1 = df2.format(date);
        
        System.out.println("The time is "+ str1);
    }
}
