package Zuoye;

import java.util.Scanner;

public class Zuoye23 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.println("Please input a three integer:");
		int integer=input.nextInt();
		int i=(int)(Math.random()*900+100);
		System.out.println("The number of bonus is"+i);

		int a1=integer/100;
		int b1=(integer-a1*100)/10;
		int c1=integer-a1*100-b1*10;
		int a2=i/100;
		int b2=(i-100*a2)/10;
		int c2=i-100*a2-10*b2;
		if(integer==i){
			System.out.println("You get 10000 dollor");
		}
		else if((a1==a2||b1==c2||c1==b2)&&(a1==b2||b1==a2||c1==c2)&&(a1==b2||b1==c2||c1==a2)&&(a1==c2||b1==b2||c1==a2)&&(a1==c2||b1==a2||c1==b2)){
			System.out.println("You get 3000 dollor");
			
		}
		else if((a1==a2||b1!=b2||c1!=c2||b1!=c2||c1!=b2)&&(a1==b2||b1!=a2||c1!=c2||b1!=c2||c1!=a2)&&(a1==c2||b1!=a2||c1!=b2||b1!=b2||c1!=a2)){
			System.out.println("You get 1000 dollor");

		}
		else
			System.out.println("You get no dollor");


	}
	

}
