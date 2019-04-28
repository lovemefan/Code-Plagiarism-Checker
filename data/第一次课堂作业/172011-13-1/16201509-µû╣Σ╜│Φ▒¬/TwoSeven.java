package mypackage;
import java.util.Scanner;
public class TwoSeven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the number of minutes:");
		int minutes = input.nextInt();
		int years = minutes/(60*24*365);
		int days =( minutes/(60*24))-(years*365);
		System.out.println(minutes + "minutes is approximately " + years + " years and " + days + " days");

	}

}
