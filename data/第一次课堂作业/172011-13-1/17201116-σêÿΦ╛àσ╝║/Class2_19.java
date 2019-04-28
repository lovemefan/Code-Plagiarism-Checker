import java.util.Scanner;
public class Class2_19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        double x1,x2,x3,y1,y2,y3;
        System.out.println("Enter three points for a triangle :");
        x1=input.nextDouble();
        y1=input.nextDouble();
        x2=input.nextDouble();
        y2=input.nextDouble();
        x3=input.nextDouble();
        y3=input.nextDouble();
        double s1,s2,s3;
        s1=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
        s2=(x1-x3)*(x1-x3)+(y1-y3)*(y1-y3);
        s3=(x2-x3)*(x2-x3)+(y2-y3)*(y2-y3);
        s1=Math.pow(s1,0.5);
        s2=Math.pow(s2,0.5);
        s3=Math.pow(s3, 0.5);
        double s=(s1+s2+s3)/2;
        s=s*(s-s1)*(s-s2)*(s-s3);
        s=Math.pow(s,0.5);
        System.out.println("The area of the triangle is " + s);
	}

}
