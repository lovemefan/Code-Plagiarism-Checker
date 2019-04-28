package work_two;
import java.util.Scanner;

public class YearDay {
	public static void main(String[] args){
		System.out.print("Enter the number of minutes: ");
		Scanner input = new Scanner(System.in);
		try{
			long number = input.nextLong();
		    long totalHours = number / 60;
		    long year =  totalHours / 24 / 365;
		    long day = totalHours / 24 % 365;
		    System.out.println(number + " minutes is approimately " 
		    		+ year +" years and " + day + " days ");
		}
		finally{
			input.close();
		}
	}

}
