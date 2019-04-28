package count;

import java.util.Scanner;

public class year {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of minutes:");
		int min = input.nextInt();
		System.out.println(min + " minutes is apprximately " + (min / 60 / 24 / 365) + " years and " + (min / 60 / 24 % 365) + " days");
	}

}
