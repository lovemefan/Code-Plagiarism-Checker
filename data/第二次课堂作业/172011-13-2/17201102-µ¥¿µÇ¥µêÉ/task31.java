import java.text.DecimalFormat;
import java.util.*;
public class task31 {
   public static void main(String[] args){
	   System.out.println("Please enter the value of a,b,c: ");
	   Scanner input=new Scanner(System.in);
	   double a=0,b=0,c=0;
	   a=input.nextDouble();
	   b=input.nextDouble();
	   c=input.nextDouble();
	   double data=0;
	   data=Math.pow(b, 2)-4*a*c;
	   double sum1=0,sum2=0;
	   DecimalFormat df = new DecimalFormat( "0.000000 "); 
	   DecimalFormat df2 = new DecimalFormat( "0.00000 "); 
	   if (data>0){
		   sum1=(-b+Math.pow(data, 0.5))/(2*a);
		   sum2=(-b-Math.pow(data, 0.5))/(2*a);
		   System.out.println("The equation has two real roots,they are : "+df.format(sum1)+"and"+df2.format(sum2));
		   
	   }
	   else if (data==0){
	      sum1=-b/(2*a);
	      System.out.println("The equation has one real root,it is : "+(int)sum1);
	   }
	   else {
		   System.out.println("The equation has no real roots");
	   }
		   
		   
   }
}
