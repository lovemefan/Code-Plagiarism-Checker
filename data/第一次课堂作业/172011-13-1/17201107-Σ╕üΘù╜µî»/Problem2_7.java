package dmz;
import java.util.Scanner;
public class Problem2_7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of minutes : ");
		int minutes = input.nextInt();
		System.out.println(minutes + " minutes is approximately " + (minutes/24/60/365) + "years and " + (minutes/24/60)%365 + " days");
	}

}
