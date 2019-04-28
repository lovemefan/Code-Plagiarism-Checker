package text;
import java.util.*;


public class Distance {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("请输入点1:");
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		System.out.println("请输入点2:");
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		
		double a=Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2);
		double distance=Math.pow(a, 0.5);
		System.out.println("两点间的距离是"+distance);
	}

}
