import java.util.Scanner;
public class Year {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of minutes:");
		int num = input.nextInt();
		int day = 0,year = 0;
		day = num/(60*24);
		year = day/365;
		day = day%365;
		System.out.println(num+" minutes is approximately "+year+" years and "+day+" days");
	    if(input!=null){
	    	input.close();
	    }
	}
}
