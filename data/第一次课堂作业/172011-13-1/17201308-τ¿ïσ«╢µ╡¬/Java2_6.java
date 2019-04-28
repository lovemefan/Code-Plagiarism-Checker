import java.util.Scanner;
  public class Java2_6 {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.print("Enter a number between 0 and 1000:");
		int number = input.nextInt();
		int a = number / 100;
		int b = number % 100 / 10;
		int c = number % 10;
		int d = a + b + c;
		System.out.print("The sum of the digits is "+d);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
	}
}
