package thirdQuestion;

import java.util.Scanner;
public class ThirdQuestion {
	public static void main(String[] args){
		Scanner input =new Scanner(System.in);
		double num=0;
		System.out.println("please enter x1 and y1:");
		int x1=input.nextInt();
		int y1=input.nextInt();
		System.out.println("please enter x2 and y2:");
		int x2=input.nextInt();
		int y2=input.nextInt();
		x1=x2-x1;
		x1=x1*x1;
		y1=y2-y1;
		y1=y1*y1;
		num=x1+y1;
		num=Math.pow(num, 0.5);
		System.out.println("the distance between two points is:"+num);
		input.close();
	}

}
