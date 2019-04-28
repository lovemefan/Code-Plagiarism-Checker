import java.util.Scanner;

public class Days {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a month number between 1 and 12:");
		int month = input.nextInt();
		while (month < 1 || month >12) {
			System.out.print("Error,enter a month number between 1 and 12:");
			month = input.nextInt();
		}
		System.out.print("Enter a year number:");
		int year = input.nextInt();
		boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
		switch (month) {
			case 1:System.out.println("January " + year + " has 31 days");break;
			case 2:
				if (isLeapYear) {
					System.out.println("February " + year + " has 29 days");
				}
				else {
					System.out.println("February " + year + " has 28 days");
				}
				break;
			case 3:System.out.println("March " + year + " has 31 days");break;
			case 4:System.out.println("April " + year + " has 30 days");break;
			case 5:System.out.println("May " + year + " has 31 days");break;
			case 6:System.out.println("June " + year + " has 30 days");break;
			case 7:System.out.println("July " + year + " has 31 days");break;
			case 8:System.out.println("August " + year + " has 31 days");break;
			case 9:System.out.println("Spetember " + year + " has 30 days");break;
			case 10:System.out.println("October " + year + " has 31 days");break;
			case 11:System.out.println("November " + year + " has 30 days");break;
			case 12:System.out.println("December " + year + " has 31 days");break;
		}
	}
	
}
