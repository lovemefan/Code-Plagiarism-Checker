package ClassWork1;

import java.util.Scanner;

public class ClassWork2_7 {
	public static void main(String[] args) {
		final int day=24*60,year=365;
		int minutes;
		System.out.println("Enter the number of minutes:");
		Scanner input=new Scanner(System.in);
		minutes=input.nextInt();
		if (minutes<0) {
			System.out.println("you input error!");
		}
		else {
			int years,days;
		    days=minutes/day;
		    years=days/year;
		    days=days-years*year;
		    System.out.println(minutes+" minutes is approximately "+years+" years and "+days+" days");
	}
		}
	
}
