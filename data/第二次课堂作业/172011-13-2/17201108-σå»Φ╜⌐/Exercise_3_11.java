package exercise;
import java.util.Scanner;

public class Exercise_3_11 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int year,month;
		int months[] =  {31,28,31,30,31,30,31,31,30,31,30,31};
		String monthsEnglish[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		System.out.println("Please enter year and moth:");
		year = in.nextInt();
		month = in.nextInt();
		if (year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) {
			System.out.println(monthsEnglish[month - 1] + " has " + months[month - 1] + " days");
		} else {
			months[1] += 1;
			System.out.println(monthsEnglish[month - 1] + " has " + months[month - 1] + " days");
		}
		
		
	}
}
