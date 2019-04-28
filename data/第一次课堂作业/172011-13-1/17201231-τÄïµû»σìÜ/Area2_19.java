//by wang sibo 17201231
import java.util.Scanner;
public class Area2_19{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter three points for a triangle:");
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		
		double x3=input.nextDouble();
		double y3=input.nextDouble();
		//输入坐标
		
		double side1,side2,side3,s,area;
		side1=Math.pow((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1),0.5);
		side2=Math.pow((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3),0.5);
		side3=Math.pow((x3-x1)*(x3-x1)+(y3-y1)*(y3-y1),0.5);
		s=(side1+side2+side3)/2;
		area=Math.pow(s*(s-side1)*(s-side2)*(s-side3), 0.5);
		System.out.println("The area of the triang is "+area);
	}//计算并输出
}
