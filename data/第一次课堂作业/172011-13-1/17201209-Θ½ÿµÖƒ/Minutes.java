package Minutes;

import java.util.Scanner;

public class Minutes {
	public static void main(String[] args){
		int min,years,days;
		System.out.println("Enter the number of minutes:");
		Scanner input = new Scanner(System.in);
		min = input.nextInt();
		years = min/60/24/365;
		days = (min-years * 365 * 24 * 60)/60/24;
		System.out.println(min+" minutes is approximately " +years+ " years and " +days+ " days");
	}

}

