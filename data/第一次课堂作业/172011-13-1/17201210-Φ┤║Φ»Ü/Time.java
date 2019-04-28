package time;

import java.util.Scanner;

public class Time {
	public static void main(String[] args){
		int m,h,d1,d2,y;
		
		System.out.println("Enter the number of minutrs:");
		Scanner input = new Scanner(System.in);
		m=input.nextInt();
		h=m/60;
		d1=h/24;
		d2=d1%365;
		y=d1/365;
		System.out.println(+m+" mintes is approximately "+y+"years and "+d2+"days.");
	}

}
