import java.util.Scanner;

public class NumberOfYears {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of minutes:");
		long minutes = input.nextLong();
		long years = minutes / 60 / 24 / 365;
		long days = minutes / 60 / 24 % 365;
		System.out.println(minutes + " minutes is approximately " + years + " years and " + days + " days");
	}
	

}
