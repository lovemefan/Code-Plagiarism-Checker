package year;

import java.util.Scanner;

public class year {
	public static void main(String[] args){
		Scanner input =new Scanner(System.in);
		System.out.print("Enter the number of minutes:");
		int minutes=input.nextInt();
		int days=minutes/1440;
		int years=days/365;
		System.out.println(minutes+" minutes is approximately "+years+" years "+days+" days");
	}
}
	
