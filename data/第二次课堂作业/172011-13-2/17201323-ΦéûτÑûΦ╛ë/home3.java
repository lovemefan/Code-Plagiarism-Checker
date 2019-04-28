package work;

import java.util.Scanner;

public class home3 {
	public static void main(String[] args){
		int lottery = (int)(Math.random() * 1000);
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your lotter pick (two digits):");
		int guss = input.nextInt();
		int lotteryDigit1 = lottery / 100;
		int lotteryDigit2 = lottery / 10 % 10;
		int lotteryDigit3 = lottery % 10;
		int gussDigit1 = guss / 100;
		int gussDigit2 = guss / 10 % 10;
		int gussDigit3 = guss % 10;
		System.out.println("The lottery number is " + lottery);
		
		if (guss == lottery)
			System.out.println("Exact match :you win $10,000");
		else if (((gussDigit1 == lotteryDigit1) && (gussDigit2 == lotteryDigit3) && (gussDigit3 == lotteryDigit2)) 
				|| ((gussDigit2 == lotteryDigit1) && (gussDigit1 == lotteryDigit2) && (gussDigit3 == lotteryDigit3)) 
				|| ((gussDigit2 == lotteryDigit1) && (gussDigit1 == lotteryDigit3) && (gussDigit3 == lotteryDigit1)) 
				|| ((gussDigit3 == lotteryDigit1) && (gussDigit1 == lotteryDigit2) && (gussDigit2 == lotteryDigit3)) 
				|| ((gussDigit3 == lotteryDigit1) && (gussDigit2 == lotteryDigit2) && (gussDigit1 == lotteryDigit3)))
				System.out.println("Match all digits : you win $3,000");
		else if ((gussDigit1 == lotteryDigit1) || (gussDigit1 == lotteryDigit2) || (gussDigit1 == lotteryDigit3) || (gussDigit2 == lotteryDigit1) || (gussDigit2 == lotteryDigit2) || (gussDigit2 == lotteryDigit3) || (gussDigit3 == lotteryDigit1) || (gussDigit3 == lotteryDigit2) || (gussDigit3 == lotteryDigit3))
			System.out.println("Match one digit: you win $1,000");
		else
			System.out.println("Sorry, no match");
		
	}

}
