import java.util.Scanner;
public class TriangleArea//求三角形面积-2.19
{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter x1 and y1:");
		double x1=input.nextDouble();
		double y1=input.nextDouble();//输入第一个点
		
		System.out.println("Enter x2 and y2:");
		double x2=input.nextDouble();
		double y2=input.nextDouble();//输入第二个点
		
		System.out.println("Enter x3 and y3:");
		double x3=input.nextDouble();
		double y3=input.nextDouble();//输入第三个点
		
		double a=distance(x1,y1,x2,y2);
		double b=distance(x2,y2,x3,y3);
		double c=distance(x3,y3,x1,y1);//调用函数求边
		
		double s=(a+b+c)/2;
		double area=Math.pow(s*(s-a)*(s-b)*(s-c), 0.5);
		System.out.printf("The area of the triangle is %.2f",area);
		
	}
	public static double distance(double x1, double y1 ,double x2, double y2) {
		double a=Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2);
		double dis=Math.pow(a, 0.5);
		return dis;
	}
}
