import java.util.Scanner;

public class workOne {
	public static void main(String[] args) {
		int num;
		int sum=0;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number between 0 and 1000:");
		do {
			num = input.nextInt();
			if(num<0||num>1000) {
				System.out.print("Error,input again:");
			}
		} while(num<0||num>1000);
		while(num>0) {
			sum += num%10;
			num /=10;
		}
		System.out.println("The sum of the digits is "+sum);
	}

}
