import java.util.Scanner;

public class Lottery {
	public static void main(String[] args){
		int lottery = (int)(Math.random() * 1000);
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your lottery pick (three digits):");
		int guess = input.nextInt();
		int a1 = lottery / 100;
		int a2 = lottery / 10 % 10;
		int a3 = lottery % 100;
		int b1 = guess / 100;
		int b2 = guess / 10 % 10;
		int b3 = guess % 100;
		System.out.print("The lottery number is " + lottery);
		if(guess == lottery)
			System.out.print(" Exact match: you win $10000");
		else if((a1==b1 && a2==b3 && a3==b2) || (a1==b2 && a2==b1 && a3==b3) || (a1==b2 && a2==b3 && a3==b1) || (a1==b3 && a2==b1 && a3==b2) || (a1==b3 && a2==b3 && a3==b1))
			System.out.print(" Exact all match: you win $3000");
		else if(a1==b1 || a1==b2 || a1==b3 || a2==b1 || a2==b2 || a2==b3 || a3==b1 || a3==b2 || a3==b3)
			System.out.print(" Exact match: you win $1000");
		else
			System.out.print(" Sorry , no match");
	}

}
