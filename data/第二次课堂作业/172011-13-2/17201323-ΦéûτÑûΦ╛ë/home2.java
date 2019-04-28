package work;

import java.util.Scanner;

public class home2 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter month and years:");
		int month = input.nextInt();
		int years = input.nextInt();
		if ((month != 2) && (month > 0) && (month < 13)) {
			switch (month){
			case 1:System.out.println("January " + years + " has 31 days");
			case 3:System.out.println("March " + years + " has 31 days");
			case 4:System.out.println("April " + years + " has 30 days");
			case 5:System.out.println("May " + years + " has 31 days");
			case 6:System.out.println("June " + years + " has 30 days");
			case 7:System.out.println("July " + years + " has 31 days");
			case 8:System.out.println("August " + years + " has 31 days");
			case 9:System.out.println("September " + years + " has 30 days");
			case 10:System.out.println("October " + years + " has 31 days");
			case 11:System.out.println("November " + years + " has 30 days");
			case 12:System.out.println("December " + years + " has 31 days");
			}
		}
		else {
			if(((years % 4 == 0) && (years % 100 != 0)) ||(years % 400 == 0)){
				System.out.println("February " + years + " has 29 days");
			}
			else {
				System.out.println("February " + years + " has 28 days");
			}
		}
	}
}
