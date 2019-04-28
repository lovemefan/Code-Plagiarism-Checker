package lab2;

import java.util.Scanner;

public class Work3_15 {

	public static void main(String[] args) {
		int lottery = 100 + (int)(Math.random() * 900);
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your lottery pick (three digits):");
		int guess = input.nextInt();
		int lotteryDigits1 = lottery / 100;
		int lotteryDigits2 = (lottery % 100) / 10;
		int lotteryDigits3 = lottery % 10; 
		int guessDigits1 = guess / 100;
		int guessDigits2 = (guess % 100) / 10;
		int guessDigits3 = guess % 10; 
		System.out.println("The lottery number is "+ lottery);
		if (guess == lottery)
			System.out.println("Exact match: you win $10,000");
		else if ((guessDigits1 == lotteryDigits2 && guessDigits2 == lotteryDigits1 && guessDigits3 == lotteryDigits3) 
			|| (guessDigits1 == lotteryDigits2 && guessDigits2 == lotteryDigits3 && guessDigits3 == lotteryDigits1)
			|| (guessDigits1 == lotteryDigits3 && guessDigits2 == lotteryDigits1 && guessDigits3 == lotteryDigits2)
			|| (guessDigits1 == lotteryDigits3 && guessDigits2 == lotteryDigits2 && guessDigits3 == lotteryDigits1) ) {
			System.out.println("Match all digits: you win $3,000");
		}
		else if ((guessDigits1 == lotteryDigits1) || (guessDigits1 == lotteryDigits2) ||(guessDigits1 == lotteryDigits3)
				|| (guessDigits2 == lotteryDigits1) ||(guessDigits2 == lotteryDigits2) || (guessDigits2 == lotteryDigits3)
				|| (guessDigits3 == lotteryDigits1) ||(guessDigits3 == lotteryDigits2) || (guessDigits3 == lotteryDigits3)) {
			System.out.println("Match one digit: you win $1,000");
		}
		else {
			System.out.println("Sorry,no match");
		}

	}

}
