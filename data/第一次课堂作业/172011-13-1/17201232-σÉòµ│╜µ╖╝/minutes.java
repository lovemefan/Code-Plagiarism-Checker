import java.util.Scanner;

public class minutes {
	public static void main(String[] args){
	System.out.println("Enter the number of minutes:");
	Scanner input = new Scanner (System.in);
	
	int  minutes = input.nextInt();
	
	int year = minutes / (60*24*365);
	int day = (minutes / 60 / 24) % 365;
	System.out.println(minutes + " minutes is apporximately " + year + " years " + " and " + day + " days");
	
	
	}
}
