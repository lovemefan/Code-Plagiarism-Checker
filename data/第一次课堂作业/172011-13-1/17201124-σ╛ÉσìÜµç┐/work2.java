package work;

import java.util.Scanner;

public class work2 {
	public static void main(String[] args){
		
			int minutes;
			
			System.out.println("Enter the number of minutes");
			
			Scanner input  = new Scanner(System.in);
			
			minutes = input.nextInt();
			
			int year,day;
			
			year=(minutes/(60*24*365));
			
			day=(minutes-year*60*24*365)/(60*24);
			
			System.out.println(minutes + " minutes is approximately " + year + " years and " + day + " days");
		
	}
}
