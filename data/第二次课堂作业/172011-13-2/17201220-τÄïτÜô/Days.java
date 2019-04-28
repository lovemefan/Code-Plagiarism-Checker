package testtwo;

import java.util.Scanner;

public class Days {
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("Enter the month and year: ");
		int month  = input.nextInt();
		int year  = input.nextInt();
		int days = 0;
		if (month==1){
			days = 31;
			System.out.println("January " + year + " has " + days +" days ");
		}
		else if(month==3){
			days = 31;
			System.out.println("March " + year + " has " + days +" days ");
		}
		else if(month==5){
			days = 31;
			System.out.println("May " + year + " has " + days +" days ");
		}
		else if(month==7){
			days = 31;
			System.out.println("July " + year + " has " + days +" days ");
		}
		else if(month==8){
			days = 31;
			System.out.println("August " + year + " has " + days +" days ");
		}
		else if(month==10){
			days = 31;
			System.out.println("October " + year + " has " + days +" days ");
		}
		else if(month==12){
			days = 31;
			System.out.println("December " + year + " has " + days +" days ");
		}
		else if (month==4){
			days = 30;
		    System.out.println("April " + year + " has " + days +" days ");
		}
		else if (month==6){
			days = 30;
		    System.out.println("June " + year + " has " + days +" days ");
		}
		else if (month==9){
			days = 30;
		    System.out.println("September " + year + " has " + days +" days ");
		}
		else if (month==11){
			days = 30;
		    System.out.println("November " + year + " has " + days +" days ");
		}
		if (year%400==0 || (year%4==0 && year%100!=0)){
			if (month==2){
				days = 29;
			    System.out.println("February " + year + " has " + days +" days ");
			}			
		}
		else{
			if (month==2){
				days = 28;
			    System.out.println("February " + year + " has " + days +" days ");
			}
		}
	}
}