import java.util.Scanner;
public class Root {
	public static void main(String[] args){
	System.out.println("please input a b and c ");
	Scanner input=new Scanner(System.in);
	double a=input.nextDouble();
	double b=input.nextDouble();
	double c=input.nextDouble();
	double r1=(-b+Math.pow((b*b-4*a*c),0.5))/2*a;
	double r2=(-b-Math.pow((b*b-4*a*c),0.5))/2*a;
	double root=b*b-4*a*c;
	if(root>0)
		System.out.println("this equation's roots are "+r1 +r2);
	
	else if(root==0)
		System.out.println("this equation's root is"+r1);
	else
		System.out.println("NO ROOT");
		
	}
	
	}


