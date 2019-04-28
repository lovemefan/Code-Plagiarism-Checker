package work;

import java.util.Scanner;

public class C3_15 {
	public static void main(String[] args){
		 		   int lottery =(int)(Math.random() * 1000);
		           Scanner input=new Scanner(System.in);
		           System.out.print("Enter your lottery pick ( three digits): ");
		           int guess =input.nextInt();
		           int b1 = lottery / 100;
		           int b2 = lottery / 10 % 10;
		           int b3 = lottery % 100 %10;
		           int a1 = guess / 100;
		           int a2 = guess / 10 % 10;
		           int a3 = guess % 100 %10;
		           System.out.println("the lottery number is "+lottery);
		           if (guess == lottery)
		           {
		        	   System.out.println("Exact match:  you win $10,000 ");
		           }
		           else if  ((a1 == b2 && a2 == b1 && a3 == b3)||(a1 == b3 && a3 == b1 && a2 == b2) || (a3 == b2 && a2 == b3 && a1 == b1) || (a1 == b2 && a2 == b3 && a3 == b1) || (a1 == b3 && a2 == b1 && a3 == b2))
		           {
		        	   System.out.println("Match all digits:  you win $3,000 ");
		           }
		           else if  ((a1 == b1 && a2 == b2 && a3 != b3)||(a1 == b1 && a3 == b3 && a2 != b2)||(a2 == b2 && a3 == b3 && a1 != b1)||(a1 == b2 && a2 == b1 && a3 != b3)||(a1 == b3 && a3 == b1 && a2 != b2)||(a2 == b3 && a3 == b2 && a1 != b1)||(a1 == b1 && a3 == b2 && a2 != b3)||(a2 == b1 && a3 == b2 && a1 != b3)||(a2 == b2 && a3 == b1 && a1 != b3) || (a1 == b2 && a3 == b1 && a2 != b3)||(a2 == b1 && a3 == b3 && a1 != b2)||(a1 == b3 && a2 == b1 && a3 != b2)||(a1 == b1 && a2 == b3 && a3 != b2)||(a2 == b3 && a3 == b1 && a1 != b2)||(a1 == b3 && a2 == b2 && a3 != b1)||(a1 == b3 && a3 == b2 && a2 != b1)||(a1 == b2 && a2 == b3 && a3 != b1)||(a1 == b2 && a3 == b3 && a2 != b1))
		           {
		        	   System.out.println("Match two digits:  you win $2,000 ");
		           }
		           else if  (a1 == b2 ||a2 == b1 ||a1 == b3 ||a3 == b1 || a2 == b3 ||a3 ==b2 ||a1 == b1 || a2 == b2 ||a3 == b3)
		           {
		        	   System.out.println("Match one digits:  you win $1,000 ");
		           }
		           else
		           {
		        	   System.out.println("Sorry, no match");
		           }
		}
}