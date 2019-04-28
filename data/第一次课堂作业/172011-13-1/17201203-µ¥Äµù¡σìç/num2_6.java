package text;
import java.util.Scanner;
public class num2_6 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number between 0 and 1000£º");
		int a = input.nextInt();
		int b = 0;
		while(a>0){
			b+=a%10;
			a/=10;
		}
		System.out.println("The sum of the digits is "+b);
	}

}
