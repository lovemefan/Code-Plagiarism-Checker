import java.util.Scanner;
public class TriangleArea {
	public static void main(String[] args){
		System.out.println("Enter x1 and y1:");
		Scanner input=new Scanner(System.in);
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		System.out.println("Enter x2 and y2:");
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		System.out.println("Enter x3 and y3:");
		double x3=input.nextDouble();
		double y3=input.nextDouble();
		
		double b1=dis(x1,y1,x2,y2);
		double b2=dis(x1,y1,x3,y3);
		double b3=dis(x2,y2,x3,y3);
		
		double s=(b1+b2+b3)/2;
		double area=Math.pow(s*(s-b1)*(s-b2)*(s-b3), 0.5);
		System.out.printf("The area of the triangle is %.1f",area);
	}
	
	public static double dis(double x1,double y1,double x2,double y2){
		double distance=Math.pow((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1), 0.5);
		return distance;
	}

}
