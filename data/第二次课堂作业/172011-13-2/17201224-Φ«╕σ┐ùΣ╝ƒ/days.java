package work2;
import java.util.Scanner;
public class days {
	public static void main(String[] arg){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter year and month:");
		int year = input.nextInt();
		int month =input.nextInt();
		switch(month){
		case 1 :System.out.println("January "+year+" has 31 days");
				break;
		case 2 :System.out.println("February "+year+" has 29 days");
				break;
		case 3 :System.out.println("March "+year+" has 31 days");
				break;
		case 4 :System.out.println("April "+year+" has 30 days");
				break;
		case 5 :System.out.println("May "+year+" has 31 days");
				break;
		case 6 :System.out.println("June "+year+" has 30 days");
				break;
		case 7 :System.out.println("July "+year+" has 31 days");
				break;
		case 8 :System.out.println("August "+year+" has 31 days");
				break;
		case 9 :System.out.println("September "+year+" has 30 days");
				break;
		case 10 :System.out.println("October "+year+" has 31 days");
				break;
		case 11 :System.out.println("November "+year+" has 30 days");
				break;
		case 12 :System.out.println("December "+year+" has 31 days");
				break;
		default :System.out.println("ERROR");
		}
	}
}
