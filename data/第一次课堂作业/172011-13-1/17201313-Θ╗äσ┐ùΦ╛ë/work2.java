package classwork;
import java.util.Scanner;

public class work2 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of minutes:");
		int seconds = input.nextInt();
		int days = seconds / 1440;
		int years = days / 365;
		int day = (seconds - years * 365 * 1440) / 1440;
		System.out.println(seconds + "minutes is approximately" + years + " years and " + day + " days");
		
	}

}
