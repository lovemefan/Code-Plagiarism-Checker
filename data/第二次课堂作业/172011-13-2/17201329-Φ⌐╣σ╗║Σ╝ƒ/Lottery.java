
import java.util.Scanner;

public class Lottery {
	public static void main(String [] agrs){
		int lottery;
		while(true){
		lottery = (int)(Math.random()*1000);
		if (lottery>99){
			break;
		}
		}
		int guess;
		System.out.println(lottery);
		while(true){
			System.out.println("Enter a number between 100-1000:");
			Scanner input = new Scanner(System.in);
			guess = input.nextInt();
			if (guess>99&&guess<1000)
				break;
		}
		int lotteryDigit1 = lottery / 100;
		int lotteryDigit2 = (lottery-lotteryDigit1*100)/10;
		int lotteryDigit3 = lottery-lotteryDigit1*100-lotteryDigit2*10;
		int guessDigit1 = guess/100;
		int guessDigit2 = (guess-guessDigit1*100)/10;
		int guessDigit3 = guess-guessDigit1*100-guessDigit2*10;
		int [] guessArray={guessDigit1,guessDigit2,guessDigit3};
		int [] lotteryArray={lotteryDigit1,lotteryDigit2,lotteryDigit3};
		int flag=0;
		if (guess==lottery){
			System.out.println("Congretuation,you get $10000!");
		}else {
			for (int i=0;i<3;i++){
				for (int j=0;j<3;j++){
					if (guessArray[i]==lotteryArray[j]){
						lotteryArray[j]=-1;
						flag++;
						break;
					}
				}
			}
			if (flag==3){
				System.out.println("Congretuation,you get $3000!");
			}else if (guessDigit1==lotteryDigit1||guessDigit1==lotteryDigit2||guessDigit1==lotteryDigit3
					||guessDigit2==lotteryDigit1||guessDigit2==lotteryDigit2||guessDigit2==lotteryDigit3
					||guessDigit3==lotteryDigit3||guessDigit3==lotteryDigit3||guessDigit3==lotteryDigit3){
				System.out.println("Congretuation,you get $1000!");
			}else {
				System.out.println("It's a pity");
			}
		}
	}
}
