import java.util.Scanner;

public class YearsNumber {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number of minutes :");
		int mins = input.nextInt();
		int years = mins / ( 60 * 24 * 365 );
		int days = mins % ( 60 * 24 * 365 ) / (60 * 24);
		System.out.println(mins + "minutes is approximately " + years + " years and " + days + " days.");
	}

}
