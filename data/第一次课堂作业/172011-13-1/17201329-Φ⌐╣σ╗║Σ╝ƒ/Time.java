
import java.util.Scanner;
public class Time {
	public static void main(String[] args){
		int minTime;
		int yearTime;
		int dayTime;
		System.out.println("Enter a time of minutes:");
		Scanner input = new Scanner(System.in);
		minTime = input.nextInt();
		yearTime = minTime/(60*24*365);
		dayTime = (minTime-yearTime*(365*60*24))/(60*24);
		System.out.println(minTime + "minutes is approximately:" + yearTime+"years and " + dayTime + "day");
	}

}
