package dame;

import java.util.Scanner;

public class Triangle {
//������
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner input = new Scanner(System.in);//ʹ�����뺯��
     
    System.out.print("Enter three points for a triangle:");//��ʾ��
  
    double x1 = input.nextDouble();
    double y1 = input.nextDouble();
    
    double x2 = input.nextDouble();
    double y2 = input.nextDouble();
   
    double x3 = input.nextDouble();
    double y3 = input.nextDouble();
    
    double a = Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
    double b = Math.sqrt(Math.pow((x1-x3),2)+Math.pow((y1-y3),2));
    double c = Math.sqrt(Math.pow((x2-x3),2)+Math.pow((y2-y3),2));
    
   
    double s = (a+b+c)/2;
    double area =Math.sqrt(s*(s-a)*(s-b)*(s-c));//�������
    
    System.out.println("The area of the triangle is "+area);
	}

}
