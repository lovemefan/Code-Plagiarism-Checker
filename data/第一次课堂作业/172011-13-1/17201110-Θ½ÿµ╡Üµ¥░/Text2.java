package Text1;

import java.util.Scanner;

public class Text2 {
    	public static void main(String args[]) {
    		Scanner input = new Scanner (System.in);
    		  System.out.println("Enter the number of minutes:");
    		  int number = input.nextInt();
    		  int year = number / ( 60 * 24) / 365;
    		  int day = number / (60 * 24) - year * 365;
    		  System.out.println(number + " minutes is approximately " + year + " years and " + day + " days");
    	}
    }
