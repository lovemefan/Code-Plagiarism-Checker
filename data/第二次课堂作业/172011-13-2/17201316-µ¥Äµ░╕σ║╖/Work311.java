package Work311;

import java.util.Scanner;
public class Work311 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String englishmonth = "";
		System.out.print("Enter month and year:");
		int month = input.nextInt();
		int year = input.nextInt();
		switch(month) {
		case 1: englishmonth = "January";break;
		case 2: englishmonth = "February";break;
		case 3: englishmonth = "March";break;
		case 4: englishmonth = "April";break;
		case 5: englishmonth = "May";break;
		case 6: englishmonth = "June";break;
		case 7: englishmonth = "July";break;
		case 8: englishmonth = "August";break;
		case 9: englishmonth = "Septembe";break;
		case 10: englishmonth = "Octobe";break;
		case 11: englishmonth = "Novembe";break;
		case 12: englishmonth = "Decembe";break;
		default: System.out.println("Enter unvaluable number!");
				System.exit(1);
		}
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: System.out.println(englishmonth + " " + year + " has 31 days");break;
		case 4:
		case 6:
		case 9: 
		case 11: System.out.println(englishmonth + " " + year + " has 30 days");break;
		case 2: if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			    	System.out.println(englishmonth + " " + year + " has 29 days");
		        }
				else {
					System.out.println(englishmonth + " " + year + " has 28 days");
				}
				break;
		}
	}

}
