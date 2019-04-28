import java.util.Scanner;
public class NumYear {
	private static Scanner input;

	public static void main(String[] args) {
	    input = new Scanner(System.in);
	    System.out.print("Enter the number of the minutes:");
	    int minutes=input.nextInt();
	    int year=minutes/(24*60*365);
	    int day= minutes%(24*60*365)/(24*60);
	    System.out.println(minutes+"minutes is approximately "+ year + " years and " + day +" days");
	}
}
