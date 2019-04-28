package assignments1;

import java.util.Scanner;

public class work3_11 {
	public static void main(String[] args){
		int month,year;
		
		int[] day = {31,28,31,30,31,30,31,31,30,31,30,31};
		String mon[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the month and the year:");
		
		month = input.nextInt();
		year = input.nextInt();
		if((year % 4 == 0 && year % 100 != 0)||year % 400 == 0)
			day[1] = 29;
		System.out.println(mon[month-1]+" "+year+" has "+day[month-1]+" days");
	}

}
