package homework1;

import java.util.Scanner;

public class Year {

	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  System.out.println("Enter the number of minutes:");
	  int minutes = input.nextInt();
	  int years = minutes / (24 * 60 * 365);
	  int days = (minutes - (years * 24 * 60 * 365)) / (24 * 60);
	  System.out.println(minutes + " minutes is approximately " +
	    years + " and " + days + " days");
	}
}
