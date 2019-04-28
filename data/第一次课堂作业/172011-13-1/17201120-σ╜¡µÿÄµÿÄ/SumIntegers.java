package sumIntegers;

import java.util.Scanner;

public class SumIntegers {
	public static void main(String[] args){
		int i = 0;
		System.out.println("Enter a number between 0 and 1000:");
		Scanner input = new Scanner(System.in); 
		i = input.nextInt();
		if(i<0||i>=1000){
			System.out.println("Input out of range, please enter again");
			i = input.nextInt();
		}
		int j = i % 10;
		int k = i % 100 / 10;
		int m = i / 100;
		System.out.println("The sum of the digits is "+ (j + k + m));
			
		 
	}
	
}
