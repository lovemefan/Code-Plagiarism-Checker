package test;

import java.util.Scanner;

public class two {
	public static void main(String[] args){
		  Scanner input=new Scanner(System.in);
		  System.out.print("Enter the number of minutes:");
		  long number=input.nextLong();
		  long year=number/525600;
		  long day=(number/1440)%365;
		  System.out.println(number+"minutes is approximately"+year+"years and"+day+"days");

    }
}