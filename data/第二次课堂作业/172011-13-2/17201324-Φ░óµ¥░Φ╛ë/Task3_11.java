package task;

import java.util.Scanner;

public class Task3_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub\
		int year,month;
		System.out.print("Enter the year and the month:");
		Scanner in=new Scanner(System.in);
		year=in.nextInt();
		month=in.nextInt();
		String[] m= {"January","February","March","April","May","June","July","August","September","October","November","December"};
		int[] mr= {31,29,31,30,31,30,31,31,30,31,30,31};
		int[] mp= {31,28,31,30,31,30,31,31,30,31,30,31};
		if ((year%400==0)||(year%4==0&&year%100!=0)) {
			System.out.println(m[month-1]+" "+year+" has "+mr[month-1]);
		}else {
			System.out.println(m[month-1]+year+"has"+mp[month-1]);
		}

	}

}
