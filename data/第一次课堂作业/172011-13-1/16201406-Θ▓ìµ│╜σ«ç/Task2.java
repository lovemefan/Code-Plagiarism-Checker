import java.util.Scanner;
public class Task2 {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
		System.out.print("Enter a mumber of minutes:");
		int number = input.nextInt();
		int n1 = number/(24*60*365);
		int n2 = number/(24*60);
		int n3 = n2-n1*365;
		System.out.println( number + " minutes is approximately " + n1 + " years and " + n3 + " days");		
}
}
