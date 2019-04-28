import java.util.Scanner;
public class Work19{
	public static void main(String[] args){
		double x1,x2,x3,y1,y2,y3;
		Scanner input=new Scanner(System.in);
		System.out.print("Enter three points for a triangle:");
		x1=input.nextDouble();
		y1=input.nextDouble();
		x2=input.nextDouble();
		y2=input.nextDouble();	
		x3=input.nextDouble();
		y3=input.nextDouble();
		double l1=Math.pow((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2),0.5);
		double l2=Math.pow((x3-x2)*(x3-x2)+(y3-y2)*(y3-y2),0.5);
		double l3=Math.pow((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3),0.5);
		double s=(l1+l2+l3)/2.0;
		double area=Math.pow(s*(s-l1)*(s-l2)*(s-l3),0.5);
		System.out.println("The area of the triangle is "+area);
	}
}

