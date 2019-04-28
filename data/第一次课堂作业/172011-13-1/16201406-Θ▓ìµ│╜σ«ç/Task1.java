import java.util.Scanner;
public class Task1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a mumber between 0 and 1000:");
		int number = input.nextInt();
		int n1 = number%10;
		int n2 = number/10%10;
		int n3 = number/100%10;
		int n4 = number/1000;
		int nu = n1+n2+n3+n4;
		System.out.println("The sum of the digits is " + nu );
}
}