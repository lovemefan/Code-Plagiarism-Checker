package dmz;

import java.util.Scanner;
public class Problem3_11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String monthsName;
		System.out.print("Enter the months and years : ");
		int months = input.nextInt();
		int years = input.nextInt();
		int days;
		switch (months) {
		case 1:
			monthsName = "January";
			days = 31;
			System.out.println(monthsName + years + " has " + days + " days");
			break;
		case 2:
			monthsName = "February ";
			if(years%400 == 0 || (years%4 == 0 && years%100 != 0)) {
				days = 29;
			}
			else {
				days = 28;
			}
			System.out.println(monthsName + years + " has " + days + " days");
			break;
		case 3:
			monthsName = "March ";
			days = 31;
			System.out.println(monthsName + years + " has " + days + " days");
			break;
		case 4:
			monthsName = "April ";
			days = 30;
			System.out.println(monthsName + years + " has " + days + " days");
			break;
		case 5:
			monthsName = "May ";
			days = 31;
			System.out.println(monthsName + years + " has " + days + " days");
			break;
		case 6:
			monthsName = "June ";
			days = 30;
			System.out.println(monthsName + years + " has " + days + " days");
			break;
		case 7:
			monthsName = "July ";
			days = 31;
			System.out.println(monthsName + years + " has " + days + " days");
			break;
		case 8:
			monthsName = "August ";
			days = 31;
			System.out.println(monthsName + years + " has " + days + " days");
			break;
		case 9:
			monthsName = "September ";
			days = 30;
			System.out.println(monthsName + years + " has " + days + " days");
			break;
		case 10:
			monthsName = "October ";
			days = 31;
			System.out.println(monthsName + years + " has " + days + " days");
			break;
		case 11:
			monthsName = "November ";
			days = 30;
			System.out.println(monthsName + years + " has " + days + " days");
			break;
		case 12:
			monthsName = "December ";
			days = 31;
			System.out.println(monthsName + years + " has " + days + " days");
			break;
		default:
			System.out.println("input error");
		}
	}
}
