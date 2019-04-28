package Zuoye;

import java.util.Scanner;

public class zuoye1 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.println("Enter a number between 0 and 1000:");
		int number=input.nextInt();
		int a=number/100;
		int b=number%100/10;
		int c=number-100*a-10*b;
		int sum=a+b+c;
		System.out.println("The sum of the dights is:"+sum);
	}

}
