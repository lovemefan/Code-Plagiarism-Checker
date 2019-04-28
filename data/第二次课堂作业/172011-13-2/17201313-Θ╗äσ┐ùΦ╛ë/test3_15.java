package classtest;

import java.util.Scanner;

public class test3_15 {
	public static void main(String[] args) {
		int lottery = (int)(Math.random() * 1000);
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your lottery pick (three digits): ");
		int guess = input.nextInt();
		int lotteryDigit4 = lottery / 10;
		int lotteryDigit1 = lottery % 10;
		int lotteryDigit2 = lotteryDigit4 % 10;
		int lotteryDigit3 = lotteryDigit4 / 10;
		int guessDigit4 = guess / 10;
		int guessDigit1 = guess % 10;
		int guessDigit2 = guessDigit4 % 10;
		int guessDigit3 = guessDigit4 % 10;
		System.out.println("The lottery number is "+ lottery);
		if(guess == lottery)
			System.out.println("Exact match£»you win $10000");
		else if(guessDigit1 == lotteryDigit1 && guessDigit2 == lotteryDigit3 && guessDigit3 == lotteryDigit2 || guessDigit1 == lotteryDigit2 && guessDigit2 == lotteryDigit1 && guessDigit3 == lotteryDigit3 || guessDigit1 == lotteryDigit2 && guessDigit2 == lotteryDigit3 && guessDigit3 == lotteryDigit2 || guessDigit1 == lotteryDigit3 && guessDigit2 == lotteryDigit2 && guessDigit3 == lotteryDigit1 || guessDigit1 == lotteryDigit3 && guessDigit2 == lotteryDigit1 && guessDigit3 == lotteryDigit2)
			System.out.println("Match all digits: you win $3000");
		else if(guessDigit1 == lotteryDigit1 ||guessDigit1 == lotteryDigit2 || guessDigit1 == lotteryDigit3 || guessDigit2 == lotteryDigit1 || guessDigit2 == lotteryDigit2 || guessDigit2 == lotteryDigit3 || guessDigit3 == lotteryDigit1 || guessDigit3 == lotteryDigit2 || guessDigit3 == lotteryDigit3 )
			System.out.println("Match one digit: you win %1000");
		else
			System.out.println("Sorry, no match");
		if(input!=null){
			input.close();
		}		
		
	}
}
