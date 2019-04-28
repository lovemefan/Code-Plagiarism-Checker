package HW;

import java.util.Scanner;

	public class Hw_3_11 {
	public static void main (String[] atgs){
		Scanner input = new Scanner (System.in);
		Hw_3_11 y1 = new Hw_3_11() ;
		int[] m1 = new int [13];
		
		m1[1] = 31;
		m1[2] = 28;
		m1[3] = 31;
		m1[4] = 30;
		m1[5] = 31;
		m1[6] = 30;
		m1[7] = 31;
		m1[8] = 31;
		m1[9] = 30;
		m1[10] = 31;
		m1[11] = 30;
		m1[12] = 31;
		
		System.out.println("Enter the month and the year :");
		
		int month = input.nextInt();
		int year  = input.nextInt();
		
		int LeapY = y1.isLeapyear(year);
		
		String month_view = "";
		
		switch (month){
		case 1: month_view = "January"; break;
		case 2: month_view = "February"; break;
		case 3: month_view = "March"; break;
		case 4: month_view = "April"; break;
		case 5: month_view = "May"; break;
		case 6: month_view = "June"; break;
		case 7: month_view = "July"; break;
		case 8: month_view = "August"; break;
		case 9: month_view = "September"; break;
		case 10: month_view = "October"; break;
		case 11: month_view = "November"; break;
		case 12: month_view = "December"; break;
		default: break;
		}
		if (LeapY == 1)
			m1[2]++;
		
		System.out.println(month_view + year + " has " + m1[month] + " days");

	}
		int isLeapyear (int year) { 
		if ((year % 4 == 0)&&(year % 100 != 0)||(year % 400 == 0 ))
			return 1 ;
		else
			return 0 ;
	}

}
	/*
一月: January 
二月：February 
三月：March 
四月：April 
五月：May 
六月：June 
七月：July 
八月：August 
九月：September 
十月：October 
十一月：November 
十二月：December
	 */
