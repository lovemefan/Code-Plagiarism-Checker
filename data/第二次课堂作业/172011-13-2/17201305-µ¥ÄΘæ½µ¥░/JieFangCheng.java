package Lesson_2;

import java.util.Scanner;

public class JieFangCheng//解方程
{
	public static void main(String[] args) {
		System.out.println("please Enter a,b,c of ax*x+bx+c");
		Scanner input=new Scanner(System.in);
		
		System.out.println("please Enter a");
		double a=input.nextDouble();
		System.out.println("please Enter b");
		double b=input.nextDouble();
		System.out.println("please Enter c");
		double c=input.nextDouble();//输入方程的参数
		
		double t=b*b-4*a*c;
		double r1,r2;
		
		if(t>=0) {
			r1=-b+Math.pow(b*b-4*a*c, 0.5)/2*a;
			r2=-b-Math.pow(b*b-4*a*c, 0.5)/2*a;
			System.out.printf("The equation has two roots r1=%.2f and r2=%.2f",r1,r2);
		}
		
		else if(t==0) {
			r1=-b+Math.pow(b*b-4*a*c, 0.5)/2*a;
			System.out.println("The equation has one roots r1="+r1);
		}
		
		else {
			System.out.println("The equation has no real roots");
		}//三种解的情况
	}
}
