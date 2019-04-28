package ClassWork1;

import java.util.Scanner;

public class ClassWork2_6 {
	public static void main(String[] args) {
		int number;
		System.out.println("Enter a number between 0 and 1000:");
		Scanner input=new Scanner(System.in);
		number=input.nextInt();
		if (number<0||number>=1000) {
			System.out.println("You input error!");
		}
		else {
			int sum=0;
			while(number>0) {
				sum=sum+number%10;
				number=number/10;
			}
			System.out.println("The sum of digits is "+sum);
		}
	}

}
