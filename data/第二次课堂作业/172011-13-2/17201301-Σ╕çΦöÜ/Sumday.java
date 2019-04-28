import java.util.Scanner;

public class Sumday {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the month and year:");
		int month = input.nextInt();
		int year = input.nextInt();
		while (month <= 0 || month >12){
			System.out.println("Error!");
			System.out.println("Input month again:");
			month = input.nextInt();
		}
		int day = 0;
		boolean leapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
		String[] name = {"January", "February", "March", "April", "May", "June", "July", 
				"August", "September", "October","November", "December"};
		switch (month){
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			day = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			day = 30;
			break;
		case 2:
			if (leapYear){
				day = 29;
			}
			else
				day = 28;
			break;
		}
		System.out.println(name[month -1] + " " + year + " has " + day + " days");
		input.close();
	}

}
