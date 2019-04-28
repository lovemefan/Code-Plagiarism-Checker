package MIN;

import java.util.Scanner;

public class MIN {
	public static void main(String[] args){
		System.out.println("Enter the number of minutes:");
		Scanner input = new Scanner(System.in);
		
		int i = input.nextInt();
		int j = i/60/24/365;
		int k = i/60/24-(j*365);
		
		System.out.println(i+" minutes is approximately " +j+" years and "+k+" days");

	}
}
