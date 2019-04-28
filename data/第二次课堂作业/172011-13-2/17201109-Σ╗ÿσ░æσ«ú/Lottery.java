import java.util.Scanner;
public class Lottery {
	public static void main(String[] args) {
		int lottery = (int) (Math.random() * 1000);
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your lottery pick(three digits):");
		int guess = input.nextInt();
		int lotteryDigit1 = lottery/100;
		int lotteryDigit2 = lottery/10%10;
		int lotteryDigit3 = lottery%10;
		int guessDigit1 = guess/100;
		int guessDigit2 = guess/10%10;
		int guessDigit3 = guess%10;
		int array1[] = swap(lotteryDigit1,lotteryDigit2,lotteryDigit3);
		int array2[] = swap(guessDigit1,guessDigit2,guessDigit3);
		System.out.println("The lottery number is " + lottery);
		if(guess == lottery)
			System.out.print("Exact match: you win $10,000");
		else if(array1[0] ==array2[0] && array1[1] ==array2[1] && array1[2] ==array2[2]) 
			System.out.print("Exact match: you win $3,000");
		else if((array1[0] == array2[0] || array1[0] == array2[1] || array1[0] == array2[2])||
				 (array1[1] == array2[0] || array1[1] == array2[1] || array1[1] == array2[2])||
				 (array1[2] == array2[0] || array1[2] == array2[1] || array1[2] == array2[2]))
			System.out.print("Exact match: you win $1,000");
		else 
			System.out.print("Sorry,no match.");
	}
	public static int[] swap(int a, int b, int c) {
		int temp = 0 ;
		if(a>b){
			temp = a;
			a = b ;
			b = temp ;
	    }
		if(a>c){
			temp = a;
			a = c ;
			c = temp ;
		}
		if(b>c){
			temp = b;
			b = c ;
			c = temp ;
		}
		return new int[] {a,b,c};
	}
}
