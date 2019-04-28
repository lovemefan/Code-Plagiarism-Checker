package day;

import java.util.Scanner;

public class Day {
	public static void main(String[] args){
		int month , year;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter month : ");
		month = input.nextInt();
		System.out.println("Please enter year : ");
		year = input.nextInt();
		if (month == 2){
			if (year%4 == 0 && year%100 != 0 || year%400 == 0){
				System.out.println("February " + year +" has 29 days ");
			}
			else {
				System.out.println("February " + year +" has 28 days ");
			}
		}
		else if (month == 1)
			System.out.println("January " + year +" has 31 days ");
		else if (month == 3)
			System.out.println("March " + year +" has 31 days ");
		else if (month == 4)
			System.out.println("April " + year +" has 30 days ");
		else if (month == 5)
			System.out.println("May " + year +" has 31 days ");
		else if (month == 6)
			System.out.println("June " + year +" has 30 days ");
		else if (month == 7)
			System.out.println("July " + year +" has 31 days ");
		else if (month == 8)
			System.out.println("August " + year +" has 31 days ");
		else if (month == 9)
			System.out.println("September " + year +" has 30 days ");
		else if (month == 10)
			System.out.println("October " + year +" has 31 days ");
		else if (month == 11)
			System.out.println("November " + year +" has 30 days ");
		else if (month == 12)
			System.out.println("December " + year +" has 31 days ");
		else 
			System.out.println("We have not this month!");
	}
}
