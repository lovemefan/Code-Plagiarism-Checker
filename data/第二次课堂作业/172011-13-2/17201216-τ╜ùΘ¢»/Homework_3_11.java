import java.util.Scanner;

public class Homework_3_11 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String months[] = new String[13];
		int year, month;
		int days[] = {0, 31, 28,31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		boolean isLeapYear;
		
		months[1] = "January";
		months[2] = "February";
		months[3] = "March";
		months[4] = "Aril";
		months[5] = "May";
		months[6] = "June";
		months[7] = "July";
		months[8] = "August";
		months[9] = "September";
		months[10] = "October";
		months[11] = "November";
		months[12] = "December";
	
		System.out.println("Please input month and year:");
		month = input.nextInt();
		year = input.nextInt();
		
		if (year % 4 != 0) {
			isLeapYear = false;
		}
		else if (year % 100 == 0) {
			if (year % 400 != 0) {
				isLeapYear = false;
			}
			else {
				isLeapYear = true;
			}
		}
		else{
			isLeapYear = true;
		}
			

		
		if (isLeapYear) {
			days[2] = 29;
		}
	
		System.out.printf("%s %d has %d days", months[month], year, days[month]);
	}
}