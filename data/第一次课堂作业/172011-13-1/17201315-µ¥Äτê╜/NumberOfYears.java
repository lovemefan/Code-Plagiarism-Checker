package NumberOfYears;//2.7

import java.util.Scanner; 

public class NumberOfYears {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of minuters");
		int minuters = input.nextInt();
		int years = minuters / (60*24*365);
		int days = (minuters / (60*24)) %365;
		System.out.println(minuters + " minuters is approximately " + years + " years " + days + " days");
		if(input != null) {
			input.close();
		}
	}
}
