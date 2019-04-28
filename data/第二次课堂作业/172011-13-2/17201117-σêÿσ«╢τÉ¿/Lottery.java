package mayday001;
import java.util.Scanner;

public class Lottery {
	public static void main(String[] args){
		int lottery = (int)(Math.random()*1000);
		Scanner input = new Scanner(System.in);
		System.out.println("please enter your lottery number:");
		int guess = input.nextInt();
		int lottery1=lottery%10;
		int lottery2=lottery/10%10;
		int lottery3=lottery/100;
		
		int guess1=guess%10;
		int guess2=guess/10%10;
		int guess3=guess/100;
		if(guess==lottery){
			System.out.println("the lottery number is"+lottery+" and you guess "+guess);
			System.out.println("and you get 10000 dollars.");
		}
		
		else if((guess1==lottery2&&guess2==lottery3&&guess3==lottery3)||
				(guess1==lottery1&&guess2==lottery3&&guess3==lottery2)||
				(guess1==lottery3&&guess2==lottery2&&guess3==lottery1)||
				(guess1==lottery2&&guess2==lottery3&&guess3==lottery1)||
				(guess1==lottery3&&guess2==lottery1&&guess3==lottery2)){
			System.out.println("the lottery number is"+lottery+" and you guess "+guess);

			System.out.println("and you get 3000 dollars.");
		}
		
		else if((guess1==lottery1||guess1==lottery2||guess1==lottery3)||
				(guess2==lottery1||guess2==lottery2||guess2==lottery3)||
				(guess3==lottery1||guess3==lottery2||guess3==lottery3)){
			System.out.println("the lottery number is"+lottery+" and you guess "+guess);

			System.out.println("and you get 1000 dollars.");
		}
		else{
			System.out.println("the lottery number is"+lottery);
			System.out.println("and you get none.");
		}
	}
	
}
