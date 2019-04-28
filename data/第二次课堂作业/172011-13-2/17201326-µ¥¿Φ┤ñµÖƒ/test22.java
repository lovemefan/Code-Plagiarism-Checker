package test2;
import java.util.Scanner;

public class test22 {
	public static void  main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the year: ");
		int Year = input.nextInt();
		System.out.println("please enter the month: ");
		int Month = input.nextInt();
		int Day;
		boolean isLeapYear = (Year % 4 == 0 && Year % 100 != 0 || (Year % 400 == 0) );
		switch(Month){
			case 1:		
				Day = 31;
				System.out.println( "Janauary " +  Year + " has " + Day + " days ");
				break;
			case 3:
				Day = 31;
				System.out.println( "March " +  Year + " has " + Day + " days ");
				break;
			case 5:
				Day = 31;
				System.out.println( "May " +  Year + " has " + Day + " days ");
				break;
			case 7:
				Day = 31;
				System.out.println( "July " +  Year + " has " + Day + " days ");
				break;
			case 8:
				Day = 31;
				System.out.println( "Augest " +  Year + " has " + Day + " days ");
				break;
			case 10:
				Day = 31;
				System.out.println( "October " +  Year + " has " + Day + " days ");
				break;
			case 12:
				Day = 31;
				System.out.println( "December " +  Year + " has " + Day + " days ");
				break;
			case 2:
				Day = 28;
				if (isLeapYear){
					Day++;
				}
				System.out.println( "February " +  Year + " has " + Day + " days ");
				break;
			case 4:
				Day = 30;
				System.out.println( "April " +  Year + " has " + Day + " days ");
				break;
			case 6:
				Day = 30;
				System.out.println( "June " +  Year + " has " + Day + " days ");
				break;
			case 9:
				Day = 30;
				System.out.println( "September " +  Year + " has " + Day + " days ");
				break;
			case 11:
				Day = 30;
				System.out.println( "November " +  Year + " has " + Day + " days ");
				break;
			default:
				System.out.println("The month you enter is not permitted");
		}
	}

}
