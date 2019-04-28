package dame;

import java.util.Scanner;

public class Year {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number of minutes :");
		double n = input.nextDouble();
		int x = (int)n;
		int year = x/525600;
		int day = (x%525600)/1440;
	    System.out.println(n+" minutes is approximately "+year+" years and "+day+" days");
	}

}
