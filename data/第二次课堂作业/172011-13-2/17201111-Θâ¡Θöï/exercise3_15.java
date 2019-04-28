package exercise2;
import java.util.Scanner;
public class exercise3_15 {
	public static void main(String[] args){
		int lottery=(int)(Math.random()*1000);
		lottery=123;
		int a1=lottery%10;
		int b1=lottery/10%10;
		int c1=lottery/100;
		Scanner input=new Scanner(System.in);
		System.out.print("Enter your lottery pick(three digits):");
		int guess=input.nextInt();
		int a2=guess%10;
		int b2=guess/10%10;
		int c2=guess/100;
		System.out.println("The lottery number is "+lottery);
		if(guess==lottery)
			System.out.println("exat match: you win $10000");
		else if(((a1==b2)||(a2==c2)||(c1==b1))&&((a1==b2)||(a2==b1)||(c1==b2))&&((a1==c2)||(a2==b1)||(c1==b2))&&((a1==c2)||(a2==b2)||(c1==b1)))
			System.out.println("match all digits: you win $3000");
		else if(a1!=a2&&a1!=b2&&a1!=c2&&b1!=a2&&b1!=b2&&b1!=c2&&c1!=a2&&c1!=b2&&c1!=c2)
			System.out.println("no match");
		else
			System.out.println("match one digit: you win $1000");
	}

}
