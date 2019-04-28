import java.util.Scanner;

public class Lottery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lottery = (int)(Math.random()*1000);
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your lottery pick(three digits):");
		
	//	int lottery = input.nextInt();
		int guess = input.nextInt();
		int lotteryDigit1 =lottery%10;
		int lotteryDigit2 =lottery/10%10;
		int lotteryDigit3 =lottery/100;
        int guessDigit1 = guess%10;
        int guessDigit2 = guess/10%10;
        int guessDigit3 = guess/100; 
        System.out.println("The lottery number is " + lottery);
        if(guess==lottery)
        	System.out.println("Exact:you win $10000");
        else if((guessDigit1==lotteryDigit2&&guessDigit2==lotteryDigit1&&guessDigit3==lotteryDigit3)||
        		(guessDigit1==lotteryDigit3&&guessDigit2==lotteryDigit1&&guessDigit3==lotteryDigit2)||
        		(guessDigit1==lotteryDigit1&&guessDigit2==lotteryDigit3&&guessDigit3==lotteryDigit2)||
        		(guessDigit1==lotteryDigit3&&guessDigit2==lotteryDigit2&&guessDigit3==lotteryDigit1)||
        		(guessDigit1==lotteryDigit2&&guessDigit2==lotteryDigit3&&guessDigit3==lotteryDigit1))
        	System.out.println("Math two digits:you win $3000");
            else if((guessDigit1==lotteryDigit3&&guessDigit2!=lotteryDigit1&&guessDigit2!=lotteryDigit3&&guessDigit3!=lotteryDigit1&&guessDigit3!=lotteryDigit2)||
        		(guessDigit1==lotteryDigit2&&guessDigit2!=lotteryDigit1&&guessDigit2!=lotteryDigit3&&guessDigit3!=lotteryDigit1&&guessDigit3!=lotteryDigit3)||
        		(guessDigit1==lotteryDigit1&&guessDigit2!=lotteryDigit2&&guessDigit2!=lotteryDigit3&&guessDigit3!=lotteryDigit2&&guessDigit3!=lotteryDigit3)||
            (guessDigit1==lotteryDigit2&&guessDigit2==lotteryDigit3&&guessDigit3!=lotteryDigit1)||(guessDigit1==lotteryDigit1&&guessDigit2==lotteryDigit2&&guessDigit3!=lotteryDigit1)||
            (guessDigit1==lotteryDigit1&&guessDigit2==lotteryDigit3&&guessDigit3!=lotteryDigit3))
        	System.out.println("Math one digit:you win $1000");
             else
        	   System.out.println("Sorry,no match");
	}

}   
