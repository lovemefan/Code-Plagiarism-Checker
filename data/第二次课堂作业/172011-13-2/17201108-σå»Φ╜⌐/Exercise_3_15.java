package exercise;
import java.util.Scanner;

public class Exercise_3_15 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int lottery = (int)(Math.random() *1000),guess, k = 0;
		System.out.println("Enter your lottery pic (three digits):");
		guess = in.nextInt();
		int lotteryDigit[] = {lottery / 100,(lottery % 100) / 10,lottery % 10};
		int guessDigit[] = {guess / 100,(guess % 100) / 10,guess % 10};
		System.out.println("The lottery number is " + lottery);
		for (int i = 0; i < 3 ;i++) {
			for (int j = 0; j < 3 ;j++) {
				if(guessDigit[i] == lotteryDigit[j]) {
					lotteryDigit[j] = -1;
					k++;
					break;
				}
			}
		}
		if (guess == lottery)
			System.out.println("Exact math: you win $10,000");
		else
			System.out.println("Exact math: you win $" + k * 1000);	
	}
}
