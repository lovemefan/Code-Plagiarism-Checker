import java.util.Scanner;

public class homework {
	private static Scanner input;
	public static void main(String[] args){
		int s1,s2,a,b,c;
		System.out.println("Enter a number between 0 and 1000:");
		Scanner input = new Scanner(System.in);
		s1=input.nextInt();
		a=s1/100;
		b=s1%100/10;
		c=s1%10;
		s2=a+b+c;
		System.out.println("The sum of the digits is "+s2);
	}
}


