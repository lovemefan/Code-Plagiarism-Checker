import java.util.Scanner;

public class Exe2_7 {
	public static void main(String[] args) {
		//Create a Scanner object
		Scanner input = new Scanner(System.in);
		
		//Prompt the user to enter a number
		System.out.print("Enter a number of minutes: ");
		int number = input.nextInt();
		
		int years = number / 60 / 24 / 365;
		int days = number / 60 / 24 % 365;
		
		System.out.println(number + " minutes is approximately " + years + " years and " + days + " days");
	}
}
