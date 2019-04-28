package summation;

import java.util.Scanner;

public class Haa {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number of minutes:");
		
		int min= input.nextInt();
		int day=24*60;
		int year=24*60*365;
		int years=min/year;
		int a=min%year;
		int days=a/day;
		System.out.print(min+" minutes is approximately"+years+"years and"+days+"days.");
		
			
		
		
		
		
		

	}

}
