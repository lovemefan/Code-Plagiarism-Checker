package lab2;

import java.util.Scanner;

public class Work3_11 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the month and year");
		int month = input.nextInt();
		int year = input.nextInt();
		int days = 0;
		boolean leap =(year % 4 == 0 && year % 100 != 0) ||(year % 400 ==0);
		switch (month) {
		  case 1:
			  days = 31;
			  System.out.println("January " + year + " has " + days + " days");
			  break;
		  case 3:
			  days = 31;
			  System.out.println("March " + year + " has " + days + " days");
			  break;
		  case 5:
			  days = 31;
			  System.out.println("May " + year + " has " + days + " days");
			  break;
		  case 7:
			  days = 31;
			  System.out.println("July " + year + " has " + days + " days");
			  break;
		  case 8:
			  days = 31;
			  System.out.println("August " + year + " has " + days + " days");
			  break;
		  case 10:
			  days = 31;
			  System.out.println("October " + year + " has " + days + " days");
			  break;
		  case 12:
			  days = 31;
			  System.out.println("December " + year + " has " + days + " days");
			  break;
		  case 4:
			  days = 30;
			  System.out.println("April " + year + " has " + days + " days");
			  break;
		  case 6:
			  days = 30;
			  System.out.println("June " + year + " has " + days + " days");
			  break;
		  case 9:
			  days = 30;
			  System.out.println("September " + year + " has " + days + " days");
			  break;
		  case 11:
			  days = 30;
			  System.out.println("November " + year + " has " + days + " days");
			  break;
		  case 2:
			  if(leap) {
			      days = 29;
			      System.out.println("February " + year + " has " + days + " days");
				  break;
		  }
		  else {
			  System.out.println("February " + year + " has " + days + " days");
			  days  = 28;
		  }
		  break;
		}
		

	}

}
