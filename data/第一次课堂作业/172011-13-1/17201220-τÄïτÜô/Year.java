package sum;

import java.util.Scanner;

public class Year {
	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("Enter the number of minutes: ");
		double min = input.nextDouble();
		int year = (int) (min/60/24/365);
		int day = (int) ((min - year*24*60*365)/60/24);
		System.out.println(min + " minute is approximately " + year + " years and " + day + " days");
	}

}
