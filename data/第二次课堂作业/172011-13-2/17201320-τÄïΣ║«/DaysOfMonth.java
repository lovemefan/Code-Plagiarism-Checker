import java.util.Scanner;

public class DaysOfMonth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("enter a year and a month: ");
		int year = input.nextInt();
		int month = input.nextInt();
		int monthDay = 0;
		String monthName = null;
		switch(month) {
		case 1:monthName = "January"; monthDay = 31;break;
		case 3:monthName = "March";monthDay = 31;break;
		case 5:monthName = "May";monthDay = 31;break;
		case 7:monthName = "July";monthDay = 31;break;
		case 8:monthName = "August";monthDay = 31;break;
		case 10:monthName = "Octubor";monthDay = 31;break;
		case 12: monthName = "December"; monthDay = 31; break;
		case 4:monthName = "Aprial";  monthDay = 30;break;
		case 6:monthName = "June"; monthDay = 30;break;
		case 9:monthName = "September"; monthDay = 30;break;
		case 11: monthName = "Novermber"; monthDay = 30; break ;
		}
		if(isLeapYear(year) == true && month == 2) {
			monthDay = 29;
			monthName =  "February";
		}
		if(isLeapYear(year) == false && month == 2){
			monthDay = 28;
			monthName =  "February";
		}
		System.out.println(monthName + " " + year + " has " + monthDay + " days");
		if(input != null) {
			input.close();
		}
	}
	
	public static boolean isLeapYear(int year) {
		boolean isLeap = (year % 4 ==0 && year % 100 != 0) || (year % 400 == 0);
		return isLeap;
	}
}
