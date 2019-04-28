package mypackage;
import java.util.Scanner;
public class TwoSix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Enter a number between 0 and 1000:");
		int num = input.nextInt();
		int dig_1 = num%10;
		int dig_2 = (num/10)/10;
		int dig_3 = (num/100);
		int total = dig_1 + dig_2 + dig_3;
		System.out.println("The total is  " + total);

	}

}
