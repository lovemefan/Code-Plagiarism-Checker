import java.util.Scanner;
public class Lottery {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.println("please input a digit number");
		int a=input.nextInt();
		int b=(int)(Math.random()*1000);
		int n1=a%10;
		int n2=a/10%10;
		int n3=a/100;
		int num1=b%10;
		int num2=b/10%10;
		int num3=b/100;
		if(a==b)
			System.out.println("The lottery number is "+b+" Exact math: you win $10,000");
		else if(n1==num1&&n2==num3&&n3==num2
				||n2==num2&&n1==num3&&n3==num1
				||n3==num3&&n1==num2&&n2==num1
				||n1==num2&&n2==num3&&n3==num1
				||n1==num3&&n2==num1&&n3==num2)
			System.out.println("The lottery number is "+b+" Exact math: you win $3,000");
		else if(n1==num1&&n2!=num3&&n2!=num2&&n3!=num3&&n3!=num2
				||n2==num2&&n1!=num3&&n1!=num1&&n3!=num3&&n3!=num1
				||n3==num3&&n2!=num1&&n2!=num2&&n1!=num2&&n1!=num1)
			System.out.println("The lottery number is "+b+" Exact math: you win $1,000");
		else
			System.out.println("The lottery number is"+b+"Sorry.no match");
		
		}
	}


