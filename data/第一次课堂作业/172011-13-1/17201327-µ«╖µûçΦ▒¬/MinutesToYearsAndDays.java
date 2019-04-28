import java.util.Scanner;

public class MinutesToYearsAndDays {

	public static void main(String[] args) {
		System.out.print("Enter the number of minutes:");
		Scanner input = new Scanner(System.in);
		int minutes = input.nextInt();
		int years = minutes / (24 * 60 * 365);
		int days = minutes % (24 * 60 * 365) / (24 * 60);
		System.out.println(minutes + " minutes is approximately " + years + " years and " + days + " days");
	}
	
}
