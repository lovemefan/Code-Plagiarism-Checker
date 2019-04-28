package test;
import java.util.Scanner;

public class exe2_7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of minutes: ");
		int min=input.nextInt();
		int year=min/60/24/365;
		int day=min%(60*24*365)/60/24;
		System.out.println(min + " mintus is approximately "+ year +" years and "+day+" days");
	}

}
