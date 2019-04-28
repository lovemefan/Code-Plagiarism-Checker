import java.util.Scanner;

public class workTwo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of minutes:");
		double min = input.nextDouble();
		int year = (int)min/60/24/365;
		int day = (int)(min/60/24)%365;
		System.out.println(min+" minutes is approximately "+year+" years and "+day+" days");
	}

}
