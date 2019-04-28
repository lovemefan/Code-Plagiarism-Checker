import java.util.Scanner;

public class Lottery {

	public static void main(String[] args) {
		int lottery = (int)((Math.random()) * 1000);
		while (lottery == 0) {
			lottery = (int)((Math.random()) * 1000);
		}
		
		//lottery = 256;测试用
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your lottery pick(three digits):");
		int guess = input.nextInt();
		
		int[] lotteryDigit = new int[3];
		int[] guessDigit = new int[3];
		
		lotteryDigit[0] = lottery / 100;
		lotteryDigit[1] = lottery / 10 % 10;
		lotteryDigit[2] = lottery % 10;
		
		guessDigit[0] = guess / 100;
		guessDigit[1] = guess / 10 % 10;
		guessDigit[2] = guess % 10;
		
		int flag = 0;
		for (int i = 0;i < 3;i++) {
			for (int j = 0;j < 3;j++) {
				if (lotteryDigit[i] == guessDigit[j]) {
					//如果相等下次就不比较，此处给其赋予其他值
					guessDigit[j] = -1;
					flag++;
					break;
				}
			}
		}
		
		System.out.println("The lottery is " + lottery);
		
		if (guess == lottery) {
			System.out.println("Exact match: you win $10,000");
		}
		else if (flag == 3) {
			System.out.println("Exact match: you win $3,000");
		}
		else if (flag == 1 || flag == 2) {
			System.out.println("Exact match: you win $1,000");
		}
		else 
			System.out.println("Sorry,no match");
	}
	
}
