package text;
import java.util.Scanner;
public class num2_19 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double x1,x2,x3,y1,y2,y3;
		System.out.print("Enter three points for the triangle: ");
		x1=input.nextDouble();
		y1=input.nextDouble();
		x2=input.nextDouble();
		y2=input.nextDouble();
		x3=input.nextDouble();
		y3=input.nextDouble();
		double a,b,c,d,e,f;
		a=Math.pow(x1-x2,2);
		b=Math.pow(x1-x3,2);
		c=Math.pow(x2-x3,2);
		d=Math.pow(y1-y2,2);
		e=Math.pow(y1-y3,2);
		f=Math.pow(y2-y3,2);
		double d1,d2,d3,s,area;
		d1=Math.pow(a+d,0.5);
		d2=Math.pow(b+e,0.5);
		d3=Math.pow(c+f,0.5);
		s=(d1+d2+d3)/2;				
		area=Math.pow(s*(s-d1)*(s-d2)*(s-d3),0.5);
		System.out.println("The area of the triangle is "+ area);
	}

}
