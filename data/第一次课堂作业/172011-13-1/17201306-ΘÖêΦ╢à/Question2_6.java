/*
 * File:Question2_6.java
 * Description:calculate sum of the digits
 * Programmer:ChenChao
 * Date:10/11/18
 */

import java.util.Scanner;

public class Question2_6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000:");
		int number = input.nextInt();
		//输入数范围校验
		while (number < 0 || number > 1000)
		{
			System.out.println("ERROR!--Enter a number between 0 and 1000:");
			number = input.nextInt();
		}
		int sum = number % 10 + number / 10 % 10 + number / 100;
		System.out.print("The sum of the digits is " + sum);
		if (input != null){
			input.close();
		}
	}
}
