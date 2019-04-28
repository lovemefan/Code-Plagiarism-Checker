package workTwo;

import java.util.Scanner;
public class three {
	public static void main(String[] args){
		int lottery=(int)(Math.random()*1000);
		Scanner input=new Scanner(System.in);
		System.out.println("Enter your lottery pick (three digits):");
		int guess=input.nextInt();
		int m=0;
		
		int lotteryDigit1=lottery/100;
		int lotteryDigit2=(lottery-lotteryDigit1*100)/10;
		int lotteryDigit3=lottery%10;
		
		int guessDigit1=guess/100;
		int guessDigit2=(guess-guessDigit1*100);
		int guessDigit3=guess%10;
		
		System.out.println("The lottery number is  "+lottery);
		
		//Check the guess
		
		if(lotteryDigit1>lotteryDigit2){
			m=lotteryDigit2;
			lotteryDigit2=lotteryDigit1;
			lotteryDigit1=m;
		}
		if(lotteryDigit2>lotteryDigit3){
			m=lotteryDigit3;
			lotteryDigit3=lotteryDigit2;
			lotteryDigit2=m;
		}
		if(lotteryDigit1>lotteryDigit2){
			m=lotteryDigit2;
			lotteryDigit2=lotteryDigit1;
			lotteryDigit1=m;
		}
		
		
		if(guessDigit1>guessDigit2){
			m=guessDigit2;
			guessDigit2=guessDigit1;
			guessDigit1=m;
		}
		if(guessDigit2>guessDigit3){
			m=guessDigit3;
			guessDigit3=guessDigit2;
			guessDigit2=m;
		}
		if(guessDigit1>guessDigit2){
			m=guessDigit2;
			guessDigit2=guessDigit1;
			guessDigit1=m;
		}
		
		if(guess==lottery)
			System.out.println("Exact match:you win $10,000");
		else if(lotteryDigit1==guessDigit1
				&&lotteryDigit2==guessDigit2
				&&lotteryDigit3==guessDigit3)
			System.out.println("Exact match:you win $3,000");
		else if(lotteryDigit1!=guessDigit1
				&&lotteryDigit2 !=guessDigit2
				&&lotteryDigit3 !=guessDigit3)
			System.out.println("no thing");
		else
			System.out.println("Exact match:you win $1,000");
		
		input.close();	
	}

}
