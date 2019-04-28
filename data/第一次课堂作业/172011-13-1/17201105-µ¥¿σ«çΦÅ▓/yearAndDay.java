package yangyufei;
import java.util.Scanner;
public class yearAndDay {

		public static void main(String [] args){
			System.out.print("Enter the number of minutes: ");
			Scanner input = new Scanner(System.in);
			int minutes = input.nextInt();
			int thedayminutes = 24 * 60;
			int theyeardays = 365;
			int theday = minutes / thedayminutes;
			int years = theday / theyeardays;
			int days = theday % theyeardays;
			System.out.print(minutes + " minutes is approximately " + years + " years and " + days +" days");
			}

	}