import java.util.Scanner;

public class YearAndDays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("Enter an minute: ");
			int number = input.nextInt();
			int yearNumber = 24 * 60 * 365;
			int dayNumber = 24 * 60;
			int years = number / yearNumber;
			int days = number / dayNumber;
			System.out.println(number + " minutes is approximately " + years + " years and " + days + " days");
		}
		finally {
			input.close();
		}
	}

}
