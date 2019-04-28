package aaa;
import java.util.Scanner;
public class Two {
	public static void main(String[] args) {
		int a=0,b=0,c=0;
		System.out.print("Enter the number of minutes: ");
		Scanner input = new Scanner(System.in);
		a=input.nextInt();
		b=a/525600;
		c=(a/1440)%365;
		System.out.print(a+" minutes is appr0ximately " + b + " years and " + c + " days ");
	}

}
