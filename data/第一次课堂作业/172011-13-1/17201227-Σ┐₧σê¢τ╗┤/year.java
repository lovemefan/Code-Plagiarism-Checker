package helloworld;

import  java.util.Scanner;

public class year {
	public static void main (String[] args){
	    int minu=0,days=0,year1=0;
	    for (;;)
		{System.out.println("Enter a number of minutes:");
		 Scanner input =new Scanner(System.in);
		 minu=input.nextInt();
		 input.close();
		 if (minu<0) 
			System.out.println("The number entered is not qualified");
		 else
		 
			 break;} 
	    days=minu/(60*24);
	    year1=days/365;
	    days=days%365;
	    System.out.println(minu + " minutes is approximately " + year1 +" years and " + days +" days");
	}

}