import java.util.*;

public class Classwork3_15 {
	public static void main(String[] args)
	{
		int lottery = (int)(Math.random()*900)+100;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number:");
		
		int number = input.nextInt();
		
		int lottery1 = lottery%10;
		int lottery2 = (lottery/10)%10;
		int lottery3 = lottery/100;
		
		int number1 = number%10;
		int number2 = (number/10)%10;
		int number3 = number/100;
		
		System.out.println("The lottery number is "+lottery);
			
		if(lottery==number)
			System.out.println("Exact match: you win $10,000");
		
		else if(lottery1==number2 && lottery2==number1 && lottery3==number3)
			System.out.println("Match all digist: you win $3,000");
		else if(lottery1==number2 && lottery2==number3 && lottery3==number1)
			System.out.println("Match all digist: you win $3,000");
		else if(lottery1==number1 && lottery2==number3 && lottery3==number2)
			System.out.println("Match all digist: you win $3,000");
		else if(lottery1==number3 && lottery2==number1 && lottery3==number2)
			System.out.println("Match all digist: you win $3,000");
		else if(lottery1==number3 && lottery2==number2 && lottery3==number1)
			System.out.println("Match all digist: you win $3,000");
		
		else if(lottery1==number1 ||lottery1==number2 ||lottery1==number3 ||
				lottery2==number2 ||lottery2==number3 ||lottery3==number3)
			System.out.println("Match one digit: you win 1,000");
		
		else
			System.out.println("Sorry: no match");
	}
}
