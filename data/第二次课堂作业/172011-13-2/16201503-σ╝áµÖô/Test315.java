package test1013;

import java.util.Scanner;

public class Test315 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lottery =(int)(Math.random()*1000);
		Scanner input =new Scanner (System.in);
		System.out.print("Enter your lottery pick (three digits):");
		int guess =input.nextInt();
		int lotteryDigit1=lottery/100;
		int lotteryDigit2=lottery%10;
		int lotteryDigit3=(lottery%100)/10;
		
		int guessDigit1=guess/100;
		int guessDigit2=guess%10;
		int guessDigit3=(guess%100)/10;
		
		System.out.println("The lottery number is"+lottery);
		
		if(guess==lottery) {
			System.out.print("Enter match:you win $10000");}
			else if((guessDigit2==lotteryDigit1&&guessDigit1==lotteryDigit2&&guessDigit3==lotteryDigit3)
					||(guessDigit2==lotteryDigit2&&guessDigit1==lotteryDigit3&&guessDigit3==lotteryDigit1)
					||(guessDigit1==lotteryDigit1&&guessDigit3==lotteryDigit2&&guessDigit2==lotteryDigit3))
				System.out.print("Match all digits:you win $3000");
			else if(guessDigit2==lotteryDigit1||guessDigit2==lotteryDigit2||guessDigit2==lotteryDigit3
				||guessDigit1==lotteryDigit2||guessDigit1==lotteryDigit3||guessDigit1==lotteryDigit1
				||guessDigit3==lotteryDigit1||guessDigit3==lotteryDigit2||guessDigit3==lotteryDigit3)
			       System.out.print("Match all digits:you win $1000");
			else 
				System.out.print("Sorry,no match");
		

			
				
				
			}
		
			
		

	}

