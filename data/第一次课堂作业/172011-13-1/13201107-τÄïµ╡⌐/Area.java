package text;
import java.util.*;


public class Area {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("�����������ε������㣺");
		System.out.println("�����������εĵ�һ���㣺");
		double x1=input.nextDouble();
		double y1=input.nextDouble();
		System.out.println("�����������εĵڶ����㣺");
		double x2=input.nextDouble();
		double y2=input.nextDouble();
		System.out.println("�����������εĵ������㣺");
		double x3=input.nextDouble();
		double y3=input.nextDouble();
		double a=Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2);
		double side1=Math.pow(a, 0.5);
		double b=Math.pow(x3-x2, 2)+Math.pow(y3-y2, 2);
		double side2=Math.pow(b, 0.5);
		double c=Math.pow(x1-x3, 2)+Math.pow(y1-y3, 2);
		double side3=Math.pow(c, 0.5);
		double s=(side1+side2+side3)/2;
		double area=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
		System.out.println("�����ε������"+area);
	}

}
