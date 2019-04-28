import java.util.Scanner;

public class task219 {
	public static double countdis(double X1,double Y1,double X2,double Y2){
		   double disx=Math.pow(X2-X1, 2);
	       double disy=Math.pow(Y2-Y1, 2);
	       double dis=Math.pow(disx+disy, 0.5);
		   return dis;
	}

	public static void main(String[] args){
		   System.out.println("Enter three points for a triangle :");
	       Scanner input=new Scanner(System.in);
	       double x1=input.nextDouble();
	       double y1=input.nextDouble();
	       double x2=input.nextDouble();
	       double y2=input.nextDouble();
	       double x3=input.nextDouble();
	       double y3=input.nextDouble();
	       double a=0,b=0,c=0,s=0;
	      a=countdis(x1,y1,x2,y2);
	      b=countdis(x1,y1,x3,y3);
	      c=countdis(x3,y3,x2,y2);
	      s=(a+b+c)/2;
	      double area=Math.pow((s*(s-a)*(s-b)*(s-c)) ,0.5);
	      
	      System.out.println("The area of the triangle is : "+(float)area);
	  }
}
