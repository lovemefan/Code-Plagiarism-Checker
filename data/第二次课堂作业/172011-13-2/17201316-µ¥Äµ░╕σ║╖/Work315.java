package Work315;
import java.util.Scanner;

public class Work315 {
	public static void main(String[] args) {
		int lottery = (int)(Math.random() * 899) + 100;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your lottery pick (three digits):");
		int guess = input.nextInt();
		int lotteryDigit1 = lottery % 10;
		int lotteryDigit2 = (lottery / 10) % 10;
		int lotteryDigit3 = (lottery / 100) % 10;
		int guessDigit1 = guess % 10;
		int guessDigit2 = (guess / 10) % 10;
		int guessDigit3 = (guess / 100) % 10;
		System.out.println("The lottery number is " + lottery);
		if(guess == lottery) {
			System.out.println("Exact match: you win $10,000");
		}
		else if((lotteryDigit1 + lotteryDigit2 + lotteryDigit3 == guessDigit1 + guessDigit2 + guessDigit3) &&
				(lotteryDigit1 * lotteryDigit1 + lotteryDigit2 * lotteryDigit2 + lotteryDigit3 * lotteryDigit3 
				== guessDigit1 * guessDigit1 + guessDigit2 * guessDigit2 + guessDigit3 * guessDigit3)) {
			System.out.println("Exact match: you win $3000");
		}
		else if(guessDigit1 == lotteryDigit1 || guessDigit1 == lotteryDigit2 || guessDigit1 == lotteryDigit3 
				|| guessDigit2 == lotteryDigit1 || guessDigit2 == lotteryDigit2 || guessDigit2 == lotteryDigit3 
				|| guessDigit3 == lotteryDigit1 || guessDigit3 == lotteryDigit2 || guessDigit3 == lotteryDigit3) {
			System.out.println("Exact match: you win $1000");
		}
		else {
			System.out.println("Sorry.no match!");
		}
	}

}
