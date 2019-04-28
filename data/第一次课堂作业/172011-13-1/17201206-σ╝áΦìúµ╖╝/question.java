/**
 * 
 */
/**
 * @author E560
 *
 */
package class1;

import java.util.Scanner;

public class question{
	public static void main(String[] args){

		Scanner input =new Scanner(System.in);
		System.out.print("enter a number between 0 and 1000:");
		int number=input.nextInt();
		//456
		int number1=number%10;
		//6
		int number2=number/10;
		//45
		int number3=number2%10;
		//5
		int number4=number2/10;
		//4
		int number5=number1+number3+number4;
		//4+5+6
		System.out.print("The sum of the digis is "+number5);
		//15
	}
	
}