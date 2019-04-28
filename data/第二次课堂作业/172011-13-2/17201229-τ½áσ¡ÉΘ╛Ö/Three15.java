import java.util.Scanner;
public class Three15 {

	public static void main(String[] args){
		int lottery = (int)(Math.random() * 1000); 
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your lottery pick (three digits):");
		int guess = input.nextInt();
		
		int l1 = lottery/100;
		int l2 = (lottery/10)%10;
		int l3 = (lottery%100)%10;
		
		int g1 = guess/100;
		int g2 = (guess/10)%10;
		int g3 = (guess%100)%10;
		
		if (lottery < 100)
			System.out.println("The lottery number is 0" + lottery);
		else
		    System.out.println("The lottery number is " + lottery);
		
		if (guess == lottery)
			System.out.println("Exact match: you win $10000");
		
		else if((l1 == g2 && l2 == g3 && l3 == g1)
			  ||(l1 == g2 && l2 == g1 && l3 == g3)
			  ||(l1 == g1 && l2 == g3 && l3 == g2)
			  ||(l1 == g3 && l2 == g1 && l3 == g2)
			  ||(l1 == g3 && l2 == g2 && l3 == g1))
			System.out.println("Exact all digits: you win $3000");
		
		else if(l1 == g1 || l1 == g2 || l1 == g3
		      ||l2 == g1 || l2 == g2 || l2 == g3
			  ||l3 == g1 || l3 == g2 || l3 == g3)
			System.out.println("Exact one digits: you win $1000");
		
		else 
			System.out.println("Sorry, no match");
	}
	
}
