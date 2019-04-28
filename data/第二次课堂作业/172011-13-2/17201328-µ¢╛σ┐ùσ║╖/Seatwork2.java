import java.util.Scanner;

public class Seatwork2 {
		public static void main(String[] args){
		System.out.println("Please enter the month");
		int month = 0;
		Scanner input1 = new Scanner(System.in);
		month = input1.nextInt();
		System.out.println("Enter the year");
		int year = 0;
		Scanner input2 = new Scanner(System.in);
		year = input2.nextInt();
			switch(month){
			case 1:
				System.out.println("January " + year + " has 31 days");
				break;
			case 2:
				if (Judge(year) == 1){
				System.out.println("February " + year + " has 29 days");
				}
				else if(Judge(year) == -1){
					System.out.println("February " + year + " has 28 days");
				}
				break;
			case 3:
				System.out.println("March " + year + " has 31 days");
				break;
			case 4:
				System.out.println("April " + year + " has 30 days");
				break;
			case 5:
				System.out.println("May " + year + " has 31 days");
				break;
			case 6:
				System.out.println("June " + year + " has 30 days");
				break;
			case 7:
				System.out.println("July" + year + " has 31 days");
				break;
			case 8:
				System.out.println("August " + year + " has 31 days");
				break;
			case 9:
				System.out.println("September " + year + " has 30 days");
				break;
			case 10:
				System.out.println("October " + year + " has 31 days");
				break;
			case 11:
				System.out.println("November " + year + " has 30 days");
				break;
			case 12:
				System.out.println("December " + year + " has 31 days");
				break;
			}
		}
		
		public static int Judge(int year){
			if (year % 400 == 0 || (year % 400 != 0 && year % 4 == 0) ){
				return 1;
			}
			else
				return -1;
			}
		
}

