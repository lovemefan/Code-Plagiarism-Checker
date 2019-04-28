//by wang sibo 17201231
import java.util.Scanner;
public class Distance2_15 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter x1 and y1:");
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		System.out.print("Enter x2 and y2:");
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		//输入坐标
		
		double a;
		a=(x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
		System.out.println("The distance between the points is"+Math.pow(a, 0.5));
	}//计算并输出
}
