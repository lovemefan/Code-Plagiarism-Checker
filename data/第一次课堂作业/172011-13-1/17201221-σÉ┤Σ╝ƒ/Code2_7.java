import java.util.Scanner;

public class Code2_7 {
	private static Scanner input;

	public static void main(String[] args){
		input = new Scanner(System.in);
		System.out.print("Enter the number of minutes:");
		long time=input.nextLong();
		long day = time/86400;
		long year = day/365;
		day=day%365;
		System.out.println(time+" minutes is approximately "+year+" years and "+day+" days.");
	}

}
