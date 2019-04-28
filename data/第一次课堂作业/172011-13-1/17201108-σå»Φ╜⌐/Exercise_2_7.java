package exercise;
import java.util.Scanner;

public class Exercise_2_7 {
	public static void main(String[] args) {
		int  minute,day,year;
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter  minutes:");
		minute = in.nextInt();
		year = minute / (365 * 24 * 60);
		day = (minute % (365 * 24 * 60)) / 60 /24;
		System.out.println(minute + " minutes is approximately " + year + " years and " + day + " days");
	}
}
