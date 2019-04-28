import java.util.*;
public class Circle {
	public static double countdis(double X1,double Y1,double X2,double Y2){
		   double disx=Math.pow(X2-X1, 2);
	       double disy=Math.pow(Y2-Y1, 2);
	       double dis=Math.pow(disx+disy, 0.5);
		   return dis;
	}
  public static void main(String[] args){
	  double x1,y1,x2,y2,r1,r2;
      System.out.println("Please enter circle1's center x-,y-coordinates and radius:");
      Scanner input=new Scanner(System.in);
      x1=input.nextDouble();
      y1=input.nextDouble();
      r1=input.nextDouble();
      System.out.println("Please enter circle2's center x-,y-coordinates and radius:");
      x2=input.nextDouble();
      y2=input.nextDouble();
      r2=input.nextDouble();
      double dis=countdis(x1,y1,x2,y2);
      double def=Math.abs(r1-r2);
      if (dis<=def){
    	  System.out.println("Circle 2 is inside circle1");
      }
      else if (dis<=r1+r2){
    	  System.out.println("Circle2 overlaps circle1");
    	  
      }
      else{
    	  System.out.println("Circle2 does not overlap circle1");
      }
    	 
  }
}
