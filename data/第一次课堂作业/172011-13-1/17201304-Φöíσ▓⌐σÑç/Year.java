package year;

import java.util.Scanner;

public class Year {
	public static void main(String[] args){
		long min , year , day ;
		System.out.println(" Enter the number of minutes: ");
		Scanner input = new Scanner(System.in);
		min = input.nextLong();
		year = min / 60 / 24 / 365;
		day = min / 60 / 24 % 365;
		System.out.println(min + " minutes is approximately " + year + " years and " + day +" days");
	}
}
