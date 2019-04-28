package Lesson_2;
import java.util.Scanner;
public class TwoCircle//两个圆的关系
{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter two circle's center x y,and radius");
		System.out.println("Enter circle1 x1");
		double x1=input.nextDouble();
		System.out.println("Enter circle1 y1");
		double y1=input.nextDouble();
		System.out.println("Enter circle1 radius");
		double r1=input.nextDouble();//输入圆1的参数
		
		System.out.println("Enter circle1 x2");
		double x2=input.nextDouble();
		System.out.println("Enter circle1 y2");
		double y2=input.nextDouble();
		System.out.println("Enter circle1 radius");
		double r2=input.nextDouble();//输入圆2的参数
		
		if(distance(x1,y1,x2,y2)<=Math.abs(r1-r2)) {
			System.out.println("circle is inside circle1");
		}
		else if(distance(x1,y1,x2,y2)==r1+r2) {
			System.out.println("circle is overlaps circle1");
		}
		else {
			System.out.println("circle does not overlap circle1");
		}//用距离判断两圆的关系
	}
	public static double distance(double x1, double y1 ,double x2, double y2) {
		double a=Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2);
		double dis=Math.pow(a, 0.5);
		return dis;//计算两点间距离
	}
}
