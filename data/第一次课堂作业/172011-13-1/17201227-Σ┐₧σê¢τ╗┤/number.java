package helloworld;

import  java.util.Scanner;

public class number {
	public static void main (String[] args){
	    int a=0,b=0,c=0,d=0;
	    for (;;)
		{System.out.println("Enter a number between 0 and 1000:");
		 Scanner input =new Scanner(System.in);
		 a=input.nextInt();
		 input.close();
		 if (a>1000||a<0) 
			System.out.println("The number entered is not qualified");
		 else
			 break;}
		b=a%10;c=a/10%10;d=a/100;
		int sum=b+c+d;
	    System.out.println("The sum of the digits is:" + sum);
	}

}
