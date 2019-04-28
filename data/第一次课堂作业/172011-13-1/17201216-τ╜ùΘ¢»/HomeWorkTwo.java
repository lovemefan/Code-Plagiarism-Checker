import java.util.Scanner;

public class HomeWorkTwo {
	
	public static void main(String [] args) {
		long n,days,years;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number of minutes:");
		n = input.nextInt();
		years = n / (365 * 24 * 60);
		days = (n / (24 * 60)) % 365;
		System.out.println(n + "minutes is approximately " + years + "years and " + days +" days");
	}
}