package lab1;

import java.util.Scanner;

public class work2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of minutes:");
		int minutes = input.nextInt();
		int days0 = minutes / (60*24);
		int days = days0 % 365;
		int years = days0 / 365;
		System.out.println(minutes + " minutes is approximately " +
		years + " years and " + days + " days");
		
	}

}
