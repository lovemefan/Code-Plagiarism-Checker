package aaa;
import java.util.Scanner;
public class One {
	public static void main(String[] args) {
		int a=0,b=0,c=0,d=0,e=0;
		System.out.print("Enter a number between 0 and 1000£» ");
		Scanner input = new Scanner(System.in);
		a=input.nextInt();
		b=a%10;
		c=(a/10)%10;
		d=a/100;
		e=b+c+d;
		System.out.println("The sum of the digits is " + e);
	}

}
