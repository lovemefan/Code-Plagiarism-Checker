package classTest1;
import java.util.Scanner;
public class Classtest26 {
			public static void main(String[] args){
			int  number;
			int bit;
			int ten;
			int hun;
			int i;
			int digitse;
			Scanner input = new Scanner(System.in);
			System.out.println("Enter a number between 0 and 1000:");
			number = input.nextInt();
			i = number / 10;
			bit = number % 10;
			hun = number / 100;
			ten = i % 10;
			digitse = hun + ten + bit;
			System.out.println("The sum of the digitse is"+digitse);
			
		}

}
