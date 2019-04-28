package yangyufei;
import java.util.Scanner;
public class Work3 {

	public static void main( String [] args){
		int num = (int) (Math.random()*1000);
	 Scanner input = new Scanner(System.in);
	 System.out.println("Enter your num pick (three digits):");
	 int guess = input.nextInt();
	 int a = num % 100;
	 int b = num / 10 % 10;
	 int c = num % 10;
	 int guess1 = num % 100;
	 int guess2 = num / 10 % 10;
	 int guess3 = num % 10;
	 System.out.println("The num is "+ num);
	 if (guess==num){
		 System.out.println("Exact match : you win $10000");
	 }
	 else if (a==guess1&&b==guess3&&c==guess2&&a==guess2&&b==guess1&&c==guess3&&a==guess2&&b==guess3&&c==guess1&&a==guess3&&b==guess1&&c==guess2&&a==guess3&&b==guess2&&c==guess1) {                     
		 System.out.println("Match all digits :you win $3000");
	}
	 else if (a==guess1||a==guess2||a==guess3||b==guess1||b==guess2||b==guess3||c==guess1||c==guess2||c==guess3)	{
		 System.out.println("Match one digits : you win $1000");
	}
	 else{
		 System.out.println("Sorry ,no match");
	 }
		 
}
}