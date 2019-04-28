package 第一次课堂作业;
import java.util.Scanner;
public class Exercise2_15 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double x1,y1,x2,y2;
		System.out.println("Enter x1 and y1 :");
        x1=input.nextDouble();
		y1=input.nextDouble();
		System.out.println("Enter x2 and y2:");
		x2=input.nextDouble();
		y2=input.nextDouble();
		double distance,a;
		a=Math.pow((x2-x1),2)+Math.pow((y2-y1),2);
		distance=Math.pow(a,0.5);
		System.out.println("The distance between the two points is "+distance);
	}
}
