package mayday001;

import java.util.Scanner;
public class calendar {
	public static void main(String[] args){
		int a,b,c = 0 ;
		System.out.println("please input the month of the year :");
		Scanner input = new Scanner(System.in);
		a = input.nextInt();
		b = input.nextInt();
		if(a%4==0&&a%100!=0||a%400==0){
			switch(b){
			case 1:
				c=31;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 2:
				c=29;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 3:
				c=31;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 4:
				c=30;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 5:
				c=31;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 6:
				c=30;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 7:
				c=31;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 8:
				c=31;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 9:
				c=30;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 10:
				c=31;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 11:
				c=30;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 12:
				c=31;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			}
		}
		else{
			switch(b){
			case 1:
				c=31;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 2:
				c=28;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 3:
				c=31;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 4:
				c=30;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 5:
				c=31;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 6:
				c=30;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 7:
				c=31;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 8:
				c=31;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 9:
				c=30;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 10:
				c=31;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 11:
				c=30;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			case 12:
				c=31;
				System.out.println("The "+b+"month of "+a+"year have "+c+"days .");
				break;
			}
		
		}
	}
}
