import java.util.Scanner;

public class Seatwork2 {
	public static void main(String args[]) {
		System.out.println("Please enter the number of minutes :");
		Scanner input =new Scanner(System.in);
		int min = 0;
		min = input.nextInt();
		if (min < 0) {
			System.out.println("Error!");
			min = input.nextInt();
		}
		int day = 0;
		day = min /(24 * 60);
		int year = 0;
		year = day / 365;
		day = day - (year * 365);
		System.out.println(min + " minutes is approximately " + year + " years and " + day + " days ");
	}
}
