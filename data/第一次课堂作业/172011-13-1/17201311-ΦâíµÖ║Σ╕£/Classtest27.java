package classTest1;
import java.util.Scanner;
public class Classtest27 {
	
		public static void main (String[] args) {
			int minutes;
			int day;
			int year;
			Scanner input = new Scanner(System.in);
			System.out.println("Enter the numbers of minutes");
			minutes = input.nextInt(); 
			year = minutes / (60*24*365);
			day = (minutes /60/24 - year*365);
			System.out.println(+minutes+"minutes is approximately "+year+"years and"+day+"days");
		}
	}

