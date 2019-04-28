import java.util.Scanner;

public class task215 {
	public static void main(String[] args){
		   System.out.println("Enter x1 and y1 :");
	       Scanner input=new Scanner(System.in);
	       double x1=input.nextDouble();
	       double y1=input.nextDouble();
	       System.out.println("Enter x2 and y2 :");
	       double x2=input.nextDouble();
	       double y2=input.nextDouble();
	       double disx=Math.pow(x2-x1, 2);
	       double disy=Math.pow(y2-y1, 2);
	       double dis=Math.pow(disx+disy, 0.5);
	       System.out.println("The distence between the two points is : "+dis);
	}
}

