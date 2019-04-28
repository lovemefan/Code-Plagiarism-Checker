package yangyufei;
import java.util.Scanner;
public class sumOfTheDigits{
	 public static void main(String[] args) {
		 System.out.print("Enter a number between 0 and 1000: ");
		 Scanner input = new Scanner(System.in);
		 int a = input.nextInt();
		 int sum = 0;
		 while ( a > 0 )
		 {
			 sum += a % 10;
			 a = a / 10;
		 }
		 System.out.print("The sum of the digits is "+ sum );
		 }
 
}