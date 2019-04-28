package text;
import java.util.Scanner;
public class num2_7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of minutes: ");
		int min=input.nextInt();
		int year=min/60/24/365;
		int a=min%(60*24*365);
		int day=a/60/24;
		System.out.println(min + " mintus is approximately "+ year +" years and "+day+" days");
		
	}

}
