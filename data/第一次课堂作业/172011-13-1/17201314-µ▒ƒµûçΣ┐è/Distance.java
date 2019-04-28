import java.util.Scanner;
public class Distance {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double x1=0,y1=0,x2=0,y2=0;
		System.out.print("Enter x1 and y1:");
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		System.out.print("Enter x2 and y2:");
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		double d;
		d=Math.pow(Math.pow(x2-x1, 2)+Math.pow(y2-y1, 2), 0.5);
		System.out.print("The distance between the two points is "+d);
	    if(input!=null){
	    	input.close();
	    }
	}

}
