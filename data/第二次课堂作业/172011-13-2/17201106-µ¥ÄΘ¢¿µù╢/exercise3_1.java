package 第二次作业;
import java.util.Scanner;
public class exercise3_1 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter three numbers :");
		double a,b,c,k;
		a=input.nextDouble();
		b=input.nextDouble();
		c=input.nextDouble();
		k=b*b-4*a*c;
		if(k>0){
		   double r1,r2;
		   r1=(-b+Math.pow(k,0.5))/2*a;
		   r2=(-b-Math.pow(k,0.5))/2*a;
		   System.out.println("The equation has two roots "+r1+"and"+r2);}
		 else if(k==0){
		   double r;
		   r=(-b+Math.pow(k,0.5))/2*a;
		   System.out.println("The equation has one root" +r);}
		 else
		   System.out.println("The equation has no real roots");
	}
}
