import java.util.Scanner;

public class Lottery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lottery = (int)(Math.random() * 1000);
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your lottery pick (three digits): ");
		int guess = input.nextInt();
		System.out.println("The lottery number is: " + lottery);		
		int lotteryDigit1 = lottery % 10;
		int lotteryDigit = lottery / 10;
		int lotteryDigit2 = lotteryDigit % 10;
		int lotteryDigit3 = lotteryDigit / 10;
		
		int guessDigit1 = guess % 10;
		int guessDigit = guess / 10;
		int guessDigit2 = guessDigit % 10;
		int guessDigit3= guessDigit / 10;
		
		if(guess == lottery) {
			System.out.println("Exact match: your win $10000");
		}
		else if((lotteryDigit1 == guessDigit1 && lotteryDigit2 == guessDigit3 && lotteryDigit3 == guessDigit2)
				|| (lotteryDigit1 == guessDigit2 && lotteryDigit2 == guessDigit3 && lotteryDigit3 == guessDigit1)
				|| (lotteryDigit1 == guessDigit2 && lotteryDigit2 == guessDigit1 && lotteryDigit3 == guessDigit3)
				|| (lotteryDigit1 == guessDigit3 && lotteryDigit2 == guessDigit2 && lotteryDigit3 == guessDigit1)
				|| (lotteryDigit1 == guessDigit3 && lotteryDigit2 == guessDigit1 && lotteryDigit3 == guessDigit2)) {
			System.out.println("Exact match: your win $3000");
		}
		else if((lotteryDigit1 == guessDigit1 && lotteryDigit2 != guessDigit3 && lotteryDigit3 != guessDigit2 && lotteryDigit2 != guessDigit2 && lotteryDigit3 != guessDigit3)
				|| (lotteryDigit2 == guessDigit2 && lotteryDigit1 != guessDigit3 && lotteryDigit3 != guessDigit1 && lotteryDigit1 != guessDigit1 && lotteryDigit3 != guessDigit3)
				
				|| (lotteryDigit3 == guessDigit3 && lotteryDigit1 != guessDigit2 && lotteryDigit2 != guessDigit1 && lotteryDigit1 != guessDigit1 && lotteryDigit2 != guessDigit2)
				
				|| (lotteryDigit1 == guessDigit2 && lotteryDigit2 != guessDigit3 && lotteryDigit2 != guessDigit1 && lotteryDigit3 != guessDigit1 && lotteryDigit3 != guessDigit3)
				
				|| (lotteryDigit1 == guessDigit3 && lotteryDigit2 != guessDigit1 && lotteryDigit2 != guessDigit2 && lotteryDigit3 != guessDigit1 && lotteryDigit3 != guessDigit2)
				
				|| (lotteryDigit2 == guessDigit3 && lotteryDigit1 != guessDigit2 && lotteryDigit1 != guessDigit1 && lotteryDigit3 != guessDigit1 && lotteryDigit3 != guessDigit2)) {
			System.out.println("Exact match: your win $1000");
		}
		else {
			System.out.println("Scorry no match!");
		}
	if(input != null) {
		input.close();
	}
}
}
