import java.util.Scanner;
public class Class2_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        double y1,y2,x1,x2;
        System.out.println("Enter x1 and x2:");
        x1=input.nextDouble();
        y1=input.nextDouble();
        System.out.println("Enter x2 and y2:");
        x2=input.nextDouble();
        y2=input.nextDouble();
        
        double t=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
        t=Math.pow(t, 0.5);
        System.out.println("The distance between the two points is "+t);
	}

}
