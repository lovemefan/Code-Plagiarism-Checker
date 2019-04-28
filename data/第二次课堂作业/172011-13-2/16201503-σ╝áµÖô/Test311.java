package test1013;

import java.util.Scanner;

public class Test311 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the year and month:");
		int year=input.nextInt();
		int month=input.nextInt();
		int days=0;
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:days=31;break;
		case 2:
			if(year%4==0) {
				days=29;}
				else days=28;break;
		case 4:
		case 6:
		case 9:
		case 11:days=30;break;}
		System.out.print("This month has"+days+"days");
		}
		
	}


