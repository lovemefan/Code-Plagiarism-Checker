package workTwo;
import java.util.Scanner;
public class first {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.println("please enter a,b,c");
		double a=input.nextDouble();
		double b=input.nextDouble();
		double c=input.nextDouble();
		double t=b*b-4*a*c;
		
		double r1=0,r2=0;
		double m=0;
		
		if(t>0){
			m=Math.pow(t, 0.5);
			r1=(-b+m)/(2*a);
			r2=(-b-m)/(2*a);
			System.out.println("The equation has two roots "+r1+ "  and  " +r2);
		}
		else if(t==0){
			m=Math.pow(t, 0.5);
			r1=(-b+m)/(2*a);
			r2=r1;
			System.out.println("The equation has one root  "+r1);
		}
		else{
			System.out.println("The equation has no real roots ");
		}
		input.close();
	}

}
