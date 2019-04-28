/*
 * File:Question2_7.java
 * Description:将分钟数换算成年数和天数
 * Programmer:ChenChao
 * Date:10/11/18
 */

import java.util.Scanner;

public class Question2_7 {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of minutes:");
		int minutes = input.nextInt();
		//输入数范围校验
		while (minutes < 0)
		{
			System.out.println("ERROR!--Enter the number of minutes greater 0:");
			minutes = input.nextInt();
		}
		int years = 0,days = 0;
		years = minutes / 60 / 24 / 365;
		days = minutes / 60 / 24 % 365;
		System.out.print(minutes + " minutes is approximately " + years + "years and " + days + "days");
		if (input != null){
			input.close();
		}
	}
}
