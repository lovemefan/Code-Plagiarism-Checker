package Text;

import java.util.Scanner;

public class Text2 {
   public static void main(String[] args) {
	 Scanner input = new Scanner(System.in);
	  System.out.println("Please enter year and month :");
	  int year = input.nextInt();
	  int month = input.nextInt();
	  int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
	String months[] = {"Janurary","Feberary","March","April","May","June","July","August","September","October","November"
			         ,"December"};
	    if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0 ) {
	    	days[1] = days[1] + 1;
	    }
	    System.out.println( months[month-1] + year + " has " + days[month-1] + " days");
   }
}
