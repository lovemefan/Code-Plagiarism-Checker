package test1;
import java.util.Scanner;

public class test1 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int flag = 1;
		int number2;
		int number3;
		int number4;
		System.out.println("Please input an integer between 0 and 1000:");
		while(flag == 1){
				int number1 = input.nextInt();	
			if (number1 > 1000||number1 < 0){
				flag = 1;
				System.out.println("Please input an another allowed integer:");
			}else { 
			flag = 0;		
			number2 = number1 / 100;
			number3 = (number1 % 100) / 10;
			number4 = number1 - 100 * number2 - 10 * number3;
			int sum = number2 + number3 + number4;
			System.out.println("The sum of the digits is:" + sum);
			}
		}
	}
}
