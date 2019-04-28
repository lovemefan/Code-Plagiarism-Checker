package hw;
	import java.util.Scanner; 
public class Hw_2_7 {
	public static void main (String[] atgs){
		Scanner input = new Scanner (System.in);
		System.out.println("Enter a number of minutes:");
		int minutes = input.nextInt();
		int years = ((minutes/60)/24)/365;
		int last_minutes = 	((minutes/60)/24)%365;	
		System.out.println( minutes + " minutes is approximately " +years+ " years and " +last_minutes+ " days");	
	}
}
