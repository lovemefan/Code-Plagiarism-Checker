package text;

import java.util.Scanner;

public class Year {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Enter the number of minters:");
		Scanner in=new Scanner(System.in);
		int min=in.nextInt();
		System.out.println(min+" minuters is approximately "+min/1440/365+" years and "+min/1440%365+" days");

	}

}
