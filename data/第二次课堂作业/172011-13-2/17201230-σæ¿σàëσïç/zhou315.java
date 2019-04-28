package zhou;

import java.util.Scanner;

public class zhou315 {
	public static void main(String[] args){
		int lottery=(int)(Math.random()*1000);
		Scanner input=new Scanner(System.in);
		System.out.print("Enter your lottery pick(three digits): ");
		int guess =input.nextInt();
		int lotterydigit1=lottery/100;//百位
		int lotterydigit2=(lottery/10)%10;//十位
		int lotterydigit3=(lottery%100)%10;//个位
		int guessdigit1=lottery/100;//百位
		int guessdigit2=(lottery/10)%10;//十位
		int guessdigit3=(lottery%100)%10;//个位
		System.out.println("The lottery number is "+lottery);
		if(guess==lottery)
			System.out.println("Exact match:you win $10000");
		else if((guessdigit1==lotterydigit1)&&(guessdigit2==lotterydigit3)
				&&(guessdigit3==lotterydigit2)
				||(guessdigit1==lotterydigit2)&&(guessdigit2==lotterydigit1)
				&&(guessdigit3==lotterydigit3)
				||(guessdigit1==lotterydigit2)&&(guessdigit2==lotterydigit3)
				&&(guessdigit3==lotterydigit1)
				||(guessdigit1==lotterydigit3)&&(guessdigit2==lotterydigit2)
				&&(guessdigit3==lotterydigit1)
				||(guessdigit1==lotterydigit3)&&(guessdigit2==lotterydigit1)
				&&(guessdigit3==lotterydigit2))
			System.out.println("Match all digits:you win $3000");
		else if(guessdigit1==lotterydigit1
				||guessdigit1==lotterydigit2
				||guessdigit1==lotterydigit3
				||guessdigit2==lotterydigit1
				||guessdigit2==lotterydigit2
				||guessdigit2==lotterydigit3
				||guessdigit3==lotterydigit1
				||guessdigit3==lotterydigit2
				||guessdigit3==lotterydigit3)
			System.out.println("Match  digit:you win $1000");
		else 
			System.out.println("Sorry,no match");
	}
}
