import java.util.Scanner;

public class Test3_29 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter circle1's center x-,y-coordinates,and radius:");
		 double x1 = input.nextDouble();
		 double y1 = input.nextDouble();
		 double rad1 = input.nextDouble();
		System.out.println("Enter circle2's center x-,y-coordinates,and radius:");
		 double x2 = input.nextDouble();
		 double y2 = input.nextDouble();
		 double rad2 = input.nextDouble();
		 int a = 2;
		 int b = 1;
		 if(rad1<0||rad2<0)
			 System.out.println("The entered radius is incorrect");
		 if(rad2>rad1){
			 a = 1;
		 	 b = 2;}
		 if( Math.pow(Math.pow((x2-x1),2)+Math.pow((y2-y1),2), 0.5)<=Math.abs(rad1-rad2))
		 System.out.println("circle"+a+" is inside ciecle"+b);
		 else if(Math.pow(Math.pow((x2-x1),2)+Math.pow((y2-y1),2), 0.5)<=rad1+rad2)
			 System.out.println("circle"+a+" overlaps circle"+b);
		 else
			 System.out.println("circle"+a+" does not overlap circle"+b);
	}
}
