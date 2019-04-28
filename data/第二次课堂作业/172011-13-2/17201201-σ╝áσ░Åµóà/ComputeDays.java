import java.util.Scanner;

public class ComputeDays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the year and the month:");
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int year = input.nextInt();
		int month = input.nextInt();
		while(year<=0||month<=0){
			System.out.println("Error!Please enter again!");
			 year = input.nextInt();
			 month = input.nextInt();
		}
		boolean isLeapyear = year%400==0||(year%4==0&&year%100!=0);
		switch(month){
		  case 0:default:System.out.print("The month is invalid!");;break;
		  case 1:System.out.println("January " + year + " has 31 days");break;
		  case 2:	
			if(isLeapyear&&month==2){
				System.out.println("February " + year + " has 29 days");
			}
			if(!isLeapyear&&month==2){
				System.out.println("February " + year + " has 28 days");
			};break;
		  case 3:System.out.println("March " + year + " has 31 days");break;
		  case 4:System.out.println("April " + year + " has 30 days");break;
		  case 5:System.out.println("May " + year + " has 31 days");break;
		  case 6:System.out.println("June " + year + " has 30 days");break;
		  case 7:System.out.println("Junly " + year + " has 31 days");break;
		  case 8:System.out.println("August " + year + " has 31 days");break;
		  case 9:System.out.println("September " + year + " has 30 days");break;
		  case 10:System.out.println("October " + year + " has 31 days");break;
		  case 11:System.out.println("November " + year + " has 30 days");break;
		  case 12:System.out.println("December " + year + " has 31 days");break;
		}

	}

}
