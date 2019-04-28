import java.util.Scanner;

public class Lottery {

	public static void main(String[] args) {
		int lottery = (int)(Math.random() * 1000);
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your lottery pick (three digits):");
		int guess = input.nextInt();
		int ld1 = lottery/100;
		int ld2 = (lottery/10)%10;
		int ld3 = lottery%10;
		int ldadd = ld1+ld2 +ld3;
		int gd1 = guess / 100;
		int gd2 = (guess/10)%10;
		int gd3 = guess%10;
		int gdadd = gd1 + gd2 + gd3;
		System.out.println("the lottery number is " +lottery);
		System.out.println("the guess number is " +guess);
		if(guess == lottery)
			System.out.println("Exact match: you win $10000");
		else if(gdadd == ldadd){
			if((gd1 == ld1 && gd2 == ld3) || (gd1 == ld1 && gd2 == ld2) || (gd1 == ld2 && gd2 == ld1) 
					|| (gd1 == ld2 && gd2 == ld3) || (gd1 == ld3 && gd2 == ld2) || (gd1 == ld3 && gd2 == ld1))
				System.out.println("Exact match: you win $3000");
			else if(gd1 == ld2 || gd1 == ld1 || gd1 == ld3 || gd2 == ld1 || gd2 == ld3 ||gd2 == ld2 
					|| gd3 == ld1 || gd3 == ld3 ||gd3 == ld2)
				System.out.println("Exact match: you win $1000");
			else 
				System.out.println("Sorry,no match");
		}
		else if(gd1 == ld2 || gd1 == ld1 || gd1 == ld3 || gd2 == ld1 || gd2 == ld3 ||gd2 == ld2 ||
				gd3 == ld1 || gd3 == ld3 ||gd3 == ld2)
			System.out.println("Exact match: you win $1000");
		else 
			System.out.println("Sorry,no match");
	}

}
