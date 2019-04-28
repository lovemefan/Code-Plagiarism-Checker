package work;
import java.util.Scanner;

public class work4 {
    public static void main(String[] args){
    	double x1,x2,y1,y2,r1,r2,d1,d2;
    	Scanner input=new Scanner(System.in);
    	System.out.println("Enter circle1's center x-,y-coordinates,and radius:");
    	x1=input.nextDouble();
    	y1=input.nextDouble();
    	r1=input.nextDouble();
    	System.out.println("Enter circle2's center x-,y-coordinates,and radius:");
    	x2=input.nextDouble();
    	y2=input.nextDouble();
    	r2=input.nextDouble();
    	d1=Math.pow(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2), 0.5);
    	d2=Math.abs(r1-r2);
    	if(d1<=d2&&r1<=r2){
    		System.out.println("circle1 is inside circle2");
    	}
    	if(d1<=d2&&r1>r2){
    		System.out.println("circle2 is inside circle1");
    	}
    	else if(d1<=(r1-r2)){
    		System.out.println("circle1 overlaps circle2");
    	}
    	else if(d1>r2+r2){
    		System.out.println("circle2 does not overlap circle 1");
    	}
    }
}
