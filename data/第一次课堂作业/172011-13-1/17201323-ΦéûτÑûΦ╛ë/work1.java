package work;
import java.util.Scanner;

public class work1 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000:");
		int num = input.nextInt();
		int sum = num/1000 + num%1000/100 + num%100/10 + num%10;
		System.out.println("The sum of the digits is:" + sum);
	}

}
