import java.util.Scanner;
public class $3_15 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		int lottery = (int)(Math.random() * 1000);
		System.out.println("Enter your lottery pick (three digits)");
		int x = input.nextInt();
		int a1 = lottery / 100;
		int a2 = (lottery / 10) % 10;
		int a3 = lottery % 10;
		
		int x1 = x/ 100;
		int x2 = (x / 10) % 10;
		int x3 = x % 10;
		System.out.println("The lottery number is " + lottery);
		
		if(x == lottery){
			
			System.out.println("Exact match: you win $10,000");
			
		}
		else if (a1 == x2 && a2 == x3 && a3 == x1 ||
				 a1 == x3 && a2 == x1 && a3 == x2 ||
				 a1 == x1 && a2 == x3 && a3 == x2 ||
				 a1 == x3 && a2 == x2 && a3 == x3 ||
				 a1 == x2 && a2 == x2 && a3 == x1)
			System.out.println("Exact match: you win $3,000");
		else if (a1 == x1 || a1 == x2 || a1 == x3 ||
				 a2 == x2 || a2 == x3 || 
				 a3 == x3)
			System.out.println("Exact match: you win $1,000");
		else
			System.out.println("Sorry, no match");

		if (input !=null){
			input.close();

	}
	}

}

