package test2_6;

import java.util.Scanner;

public class test2_6 {
	public static void main(String[] args){
		int x = 0, y = 0,z = 1;
		while(true){
		System.out.println("Enter a number between 0 and 999:");
		Scanner input = new Scanner(System.in);
		x = input.nextInt();
		if (x < 1000 && x >= 0){
			z = 0;
		}
		if(z==0){
	       break;     
		}
	  }
		y = x / 100 + x % 100 / 10 + x % 10 ;
		System.out.println("The sumof the digits is " + y);
	}

}
