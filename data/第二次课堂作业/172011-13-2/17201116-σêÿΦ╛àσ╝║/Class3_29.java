import java.util.Scanner;
public class Class3_29 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        double x1,y1,r1;
        System.out.println("Enter circle1's center x-, y-coordinates, and radius:");
        x1 = input.nextDouble();
        y1 = input.nextDouble();
        r1 = input.nextDouble();
        double x2,y2,r2;
        System.out.println("Enter circle2's center x-, y-coordinates, and radius:");
        x2 = input.nextDouble();
        y2 = input.nextDouble();
        r2 = input.nextDouble();
        double d=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
        d=Math.pow(d, 0.5);
        if (d<=Math.abs(r1-r2))
        {
        	System.out.println("circle2 is inside circle1");
        }
        else if (d<r1+r2)
        {
        	System.out.println("circle2 overlap circle1");
        }
        else
        {
        	System.out.println("circle2 does not overlap circle1");
        }
	}

}
