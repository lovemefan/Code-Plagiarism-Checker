package HomeWork;
import java.util.Scanner;
public class JavaWork2_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number of minutes:");
		Scanner input = new Scanner(System.in);
		int minutes = input.nextInt();
		int years = minutes / 60 / 24 /365 ;
		int days = minutes / 60 / 24 % 365 ;
		System.out.println(minutes +" is approximately "+ years + "years" + " and " +days+ "days");

	}

}
