package work;

import java.util.Scanner;

public class work1 {
	public static void main(String[] args){
			int number;
			
			System.out.println("Enter a number between 0-1000");
			
			Scanner input  = new Scanner(System.in);
			
			number = input.nextInt();
			
			int Position,Hundreds,Decade;
			
			Hundreds=number/100%10;
			Decade=number/10%10;
			Position=number%10;
			
			int sums=Position+Hundreds+Position;
			
			System.out.println("The digits and sums are:" + sums);
	}
}
