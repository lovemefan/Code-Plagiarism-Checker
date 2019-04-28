package Test2_7_;

import java.util.Scanner;

public class Test2_7 {
	public static void main(String[] args){
		double minutes = 0, years =0, days = 0;
		System.out.println("Enter the number of the minutes: ");
		Scanner input = new Scanner(System.in);
		minutes = input.nextDouble();
		years = minutes / (60*24*365);
		days = minutes % (60*24*365) / 1440;
		System.out.println(minutes + " minutes is approximately " + (int)years + "years and " + (int)days + " days");
	}

}
