import java.util.Scanner;

public class _2_7 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of minutes:");
		int f = input.nextInt();
		int day = f / 60 /24;
		int year = day / 365;
		day = day % 365;
		System.out.println(f + " minutes is approximately " + year + " years and " + day + " days");
	}

}
