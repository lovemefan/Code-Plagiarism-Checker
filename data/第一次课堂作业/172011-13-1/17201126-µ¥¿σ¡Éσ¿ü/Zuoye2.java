package Zuoye;

import java.util.Scanner;

public class Zuoye2 {
	public static void main(String[] args){
	Scanner input=new Scanner(System.in);
	System.out.println("Enter a number of minutes:");
	int number=input.nextInt();
	if( number<525600){
		int day=number/1440;
		System.out.println(number+"minutes is approximately 0 year and"+day+"day");
	}
	else{
		int year=number/525600;
		int day=number-525600*year;
		System.out.println(number+"minutes is approximately "+year+"year and"+day+"day");
	}
}
}
