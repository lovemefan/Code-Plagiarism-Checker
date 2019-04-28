import java.util.Scanner;
public class TwoCircle {
	public static void main(String[] agrs){
    Scanner input=new Scanner(System.in);
    System.out.println("Enter circle1's center x--coordinates,and radius:");
    double x1=input.nextDouble();
    double y1=input.nextDouble();
    double r1=input.nextDouble();
    System.out.println("Enter circle2's center x--coordinates,and radius:");
    double x2=input.nextDouble();
    double y2=input.nextDouble();
    double r2=input.nextDouble();
    double dist=Math.pow((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1), 0.5);
    if(dist<=Math.abs(r1-r2))
    	System.out.println("circle2 is inside circle1");
    else if(dist<=(r1+r2))
    	System.out.println("circle2 overlaps circle1");
    else
    	System.out.println("circle2 does not overlap circle1");

}
}
