import java.util.Scanner;
public class Java2_7 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of minutes:");
		int number = input.nextInt();
		int a = number / 365 / 24 / 60;
		int b = number % (365*24*60)/(60*24);
System.out.println("number minutes is approximately " + a + "years and " + b + "days");
	}

}
