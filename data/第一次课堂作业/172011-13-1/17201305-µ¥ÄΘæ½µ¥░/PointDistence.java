import java.util.Scanner;
public class PointDistence//求两点间距离-2.15
{
	public static void main (String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter x1 and y1:");
		double x1=input.nextDouble();
		double y1=input.nextDouble();//输入第一个点
		
		System.out.println("Enter x2 and y2:");
		double x2=input.nextDouble();
		double y2=input.nextDouble();//输入第二个点
		
		double a=Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2);
		double distance=Math.pow(a, 0.5);//根据公式计算距离
		
		System.out.println("The distance between the two points is "+distance);
	}
}
