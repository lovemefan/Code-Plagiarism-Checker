import java.util.Scanner;

public class ShowTime {
	public static void main(String[] args){
		System.out.print("Enter the number of minutes:");
		Scanner input=new Scanner(System.in);
		long minutes=input.nextLong();
		long years=minutes/(60*24*365);
		long days=minutes%(60*24*365)/(60*24);
		System.out.println(minutes+" minutes is approximately "+ years+" years and "+days+" days");
		
		
	}

}
