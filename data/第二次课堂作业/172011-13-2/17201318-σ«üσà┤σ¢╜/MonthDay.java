import java.util.Scanner;

public class MonthDay {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter year and month :");
		try{
		int years = input.nextInt();
		int months = input.nextInt();
		boolean isLeapYear = (years % 4 == 0 && years % 100 != 0 ||
				(years % 400) == 0);
		switch(months){
		case 1:System.out.println("January " + years + " has " + 31 + " days");break;
		case 2:
			if(isLeapYear){
				System.out.println("Fabruary " + years + " has " + 29 + " days");break;
			}
			else{
				System.out.println("January " + years + " has " + 28 + " days");break;
			}
		case 3:System.out.println("March " + years + " has " + 31 + " days");break;
		case 4:System.out.println("April " + years + " has " + 30 + " days");break;
		case 5:System.out.println("May " + years + " has " + 31 + " days");break;
		case 6:System.out.println("June " + years + " has " + 30 + " days");break;
		case 7:System.out.println("July " + years + " has " + 31 + " days");break;
		case 8:System.out.println("August " + years + " has " + 31 + " days");break;
		case 9:System.out.println("Sepember " + years + " has " + 30 + " days");break;
		case 10:System.out.println("October " + years + " has " + 31 +" days");break;
		case 11:System.out.println("November " + years + " has " + 30 +" days");break;
		case 12:System.out.println("December " + years + " has " + 31 + " days");break;
		}
	  }
		finally{
			input.close();
		}
	}

}
