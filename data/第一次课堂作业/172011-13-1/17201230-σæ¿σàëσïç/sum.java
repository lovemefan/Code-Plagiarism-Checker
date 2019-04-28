package sum;

import java.util.Scanner;

public class sum {
	public static void main(String[] args){
		Scanner input =new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000:  ");
		int number=input.nextInt();
		int num=number%10+(number/10)%10+number/100;
		System.out.println("The sum of the digits is "+num);
	}

}
