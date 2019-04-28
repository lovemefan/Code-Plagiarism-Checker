package project;
import java.util.Scanner;
public class P2_6 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000:");
		int num=input.nextInt();
		while(num<=0||num>=1000) {
			System.out.println("The number is not in a right range,please enter a number again");
			num=input.nextInt();
		}
		int sum=0;
		while(num>0) {
			sum=sum+num%10;
			num=num/10;
		}
	System.out.println("The sum of the digits is "+sum);
	input.close();
	}
}
