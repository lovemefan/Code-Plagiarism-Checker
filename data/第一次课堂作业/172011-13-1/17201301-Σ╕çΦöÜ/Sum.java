package homework1;

import java.util.Scanner;

public class Sum {

	public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  System.out.println("Enter an number between 0 and 1000:");
	  int num = input.nextInt();
	  while (num <= 0 || num >= 1000)
	  {
		  System.out.println("Error!");
		  System.out.println("Enter an number between 0 and 1000:");
		  num = input.nextInt();
	  }
	  int unit = num % 10;
	  int digit = num / 10 % 10;
	  int hundred = num / 100;
	  System.out.println("The hundred is " + hundred + '\n' +
	    "The digit is " + digit + '\n' +
	    "The unit is " + unit);
	  int sum = unit + digit + hundred;
	  System.out.println("The sum is " + sum);	

	}

}
