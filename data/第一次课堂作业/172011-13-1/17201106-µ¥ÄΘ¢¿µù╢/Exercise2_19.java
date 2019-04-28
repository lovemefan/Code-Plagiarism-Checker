package 第一次课堂作业;
import java.util.Scanner;
public class Exercise2_19 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double x1,y1,x2,y2,x3,y3;
		System.out.println("Enter three points for atriangle:");
		x1=input.nextDouble();
		y1=input.nextDouble();
		x2=input.nextDouble();
		y2=input.nextDouble();
		x3=input.nextDouble();
		y3=input.nextDouble();
        double d1,d2,d3,a1,a2,a3,s,area;
        a1 = Math.pow((x2-x1),2)+Math.pow((y2-y1),2);
        a2 = Math.pow((x3-x2),2)+Math.pow((y3-y2),2);
        a3 = Math.pow((x1-x3),2)+Math.pow((y1-y3),2);
        d1 = Math.pow(a1,0.5);
        d2 = Math.pow(a2,0.5);
        d3 = Math.pow(a3,0.5);
        s = (d1+d2+d3)/2;
        area = Math.pow((s*(s-d1)*(s-d2)*(s-d3)),0.5);
        System.out.println("The area of the triangle is" +area);
	}

}
